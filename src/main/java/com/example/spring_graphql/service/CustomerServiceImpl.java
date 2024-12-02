package com.example.spring_graphql.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.spring_graphql.dao.CustomerRepository;
import com.example.spring_graphql.dtos.customer.AddCustomerRequest;
import com.example.spring_graphql.dtos.customer.AddCustomerResponse;
import com.example.spring_graphql.dtos.customer.CustomerDto;
import com.example.spring_graphql.dtos.customer.UpdateCustomerRequest;
import com.example.spring_graphql.dtos.customer.UpdateCustomerResponse;
import com.example.spring_graphql.service.exception.BusinessException;
import com.example.spring_graphql.service.models.Customer;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional
public class CustomerServiceImpl implements ICustomerService {
    
    private final CustomerRepository customerRepo;
    private final ModelMapper modelMapper;


    @Override
    public List<CustomerDto> getAllCustomers() {
       return customerRepo.findAll()
              .stream()
              .map(customer -> modelMapper.map(customer,CustomerDto.class))
              .toList();   
    }

    @Override
    public AddCustomerResponse createCustomer(AddCustomerRequest addCustomerRequest) {
        Customer newCustomer = modelMapper.map(addCustomerRequest, Customer.class);
        String identityRef = newCustomer.getIdentityRef();
        String username = newCustomer.getUsername();

        customerRepo.findByIdentityRef(identityRef).ifPresent( a->{
            throw new BusinessException(String.format("Customer wiht same identity %s exist", identityRef));
        });
        
        customerRepo.findByUsername(username).ifPresent( a -> {
            throw new BusinessException(String.format("The username %s is already used", username));
        });

        AddCustomerResponse response = modelMapper.map(customerRepo.save(newCustomer), AddCustomerResponse.class);
        response.setMessage(
            String.format(
                "Customer : [identity= %s,First Name= %s, Last Name= %s, username= %s] was created with success",
                 response.getIdentityRef(),response.getFirstname(),response.getLastanme(),response.getUsername()
            )
        );  
        
        return response;
    }


    @Override
    public UpdateCustomerResponse updateCustomer(String identityRef, UpdateCustomerRequest updateCustomerRequest) {
        Customer customerToPersist = modelMapper.map(updateCustomerRequest, Customer.class);
        Customer customerFound = customerRepo.findByIdentityRef(identityRef)
            .orElseThrow( 
                () -> new BusinessException(String.format("No customer with identity %s found",identityRef))
            );
        
        customerToPersist.setId(customerFound.getId());
        customerToPersist.setIdentityRef(customerFound.getIdentityRef());
        UpdateCustomerResponse response = modelMapper.map(customerRepo.save(customerToPersist), UpdateCustomerResponse.class);
        response.setMessage(
            String.format("Customer with identity %s updated successfuly",identityRef)
        );

        return response;
    }


    @Override
    public CustomerDto getCustomerByIdentityRef(String identityRef) {
        Customer customerFound = customerRepo.findByIdentityRef(identityRef)
            .orElseThrow(
                () -> new BusinessException(String.format("No customer with identity %s was found", identityRef)) 
            );
        return modelMapper.map(customerFound,CustomerDto.class);
    }

    
    @Override
    public String deleteCustomerByIdentityRef(String identityRef) {
        if(identityRef == null || identityRef.isEmpty())
            throw new BusinessException("Enter a valid customer identity");

        Customer customerFound = customerRepo.findByIdentityRef(identityRef)
            .orElseThrow(
                () -> new BusinessException(String.format("No customer with identity %s was found", identityRef))
            );
        
        customerRepo.delete(customerFound);
        return String.format("Customer with identity %s was deleted successfuly", identityRef);
    }
    
}
