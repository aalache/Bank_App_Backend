package com.example.spring_graphql.dtos.transaction;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class GetTransactionListRequest {
    private String rib;
    private String dateFrom;
    private String dateTo;
}