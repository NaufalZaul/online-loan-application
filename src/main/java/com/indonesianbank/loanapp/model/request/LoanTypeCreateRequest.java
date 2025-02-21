package com.indonesianbank.loanapp.model.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class LoanTypeCreateRequest {
    private String type;
    private Double maxLoan;
}


