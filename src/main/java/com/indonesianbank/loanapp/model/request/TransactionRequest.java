package com.indonesianbank.loanapp.model.request;

import com.indonesianbank.loanapp.entity.Customer;
import com.indonesianbank.loanapp.entity.InstalmentType;
import com.indonesianbank.loanapp.entity.LoanType;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionRequest {
    private LoanType loanType;
    private InstalmentType instalmentType;
    private Customer customer;
    private Double nominal;
}
