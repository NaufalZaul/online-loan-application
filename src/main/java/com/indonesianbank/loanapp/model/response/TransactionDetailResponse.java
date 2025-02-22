package com.indonesianbank.loanapp.model.response;

import com.indonesianbank.loanapp.constant.LoanStatus;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionDetailResponse {
    private String id;
    private Long  transactionDate;
    private Double nominal;
    private LoanStatus loanStatus;
    private Long  createdAt;
    private Long  updatedAt;

}