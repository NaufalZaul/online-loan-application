package com.indonesianbank.loanapp.model.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class LoanTypeUpdateRequest {
    private String id;
    private String type;
    private Double maxLoan;
}
