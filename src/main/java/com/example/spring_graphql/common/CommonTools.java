package com.example.spring_graphql.common;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class CommonTools {
    
    @Value("${graphql.date.format}")
    private String dateFormat;

    public String dateToString(Date date){
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
        return formatter.format(date);
    }

    public Date stringToDate(String date) throws ParseException{
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
        return formatter.parse(date);
    }
}
