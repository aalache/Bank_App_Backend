package com.example.spring_graphql.config;

import java.text.ParseException;
import java.util.Date;

import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration.AccessLevel;
import org.modelmapper.convention.MatchingStrategies;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.spring_graphql.common.CommonTools;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
public class ModelMapperConfig {
    private CommonTools tools;

    @Bean
    ModelMapper modelMapper(){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
            .setMatchingStrategy(MatchingStrategies.LOOSE)
            .setFieldMatchingEnabled(true)
            .setSkipNullEnabled(true)
            .setFieldAccessLevel(AccessLevel.PRIVATE);

            Converter<Date,String> dateToStringConverter = new AbstractConverter<>() {
                @Override
                public String convert(Date date) {
                    return tools.dateToString(date);
                }
            };

            Converter<String,Date> stringToDateConverter = new AbstractConverter<>(){
                @Override
                public Date convert(String date)  {
                    try {
                        return tools.stringToDate(date);
                    } catch (ParseException e) {
                        throw new BusinessException(String.format("The Date %s doesn't respect the format %s",date,tools.getDateFormat()));
                    }
                }
            };

            modelMapper.addConverter(dateToStringConverter);
            modelMapper.addConverter(stringToDateConverter);
            return modelMapper;
    }


}