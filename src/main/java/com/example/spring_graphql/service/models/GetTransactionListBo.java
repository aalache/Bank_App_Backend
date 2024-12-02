package com.example.spring_graphql.service.models;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetTransactionListBo {
    private String rib;
    private Date dateTo;
    private Date dateFrom;
}
