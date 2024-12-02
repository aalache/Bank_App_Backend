package com.example.spring_graphql.service;

import com.example.spring_graphql.dtos.customer.AddCustomerResponse;
import com.example.spring_graphql.dtos.customer.AddCustomerRequest;
import com.example.spring_graphql.dtos.customer.CustomerDto;
import com.example.spring_graphql.dtos.customer.UpdateCustomerRequest;
import com.example.spring_graphql.dtos.customer.UpdateCustomerResponse;

import java.util.List;

public interface ICustomerService {

    List<CustomerDto> getAllCustomers();
    AddCustomerResponse createCustomer(AddCustomerRequest addCustomerRequest);
    UpdateCustomerResponse updateCustomer(String identityRef ,UpdateCustomerRequest updateCustomerRequest);
    CustomerDto getCustomerByIdentityRef(String identityRef);
    String deleteCustomerByIdentityRef(String identityRef);

}