package com.indonesianbank.loanapp.model.response;

import com.indonesianbank.loanapp.constant.ApprovalStatus;
import lombok.*;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TransactionResponse {
    private String id;
    private String loanTypeId;
    private String instalmentTypeId;
    private String customerId;
    private Double nominal;
    private Long approvedAt;
    private String approvedBy;
    private ApprovalStatus approvalStatus;
    private List<TransactionDetailResponse> transactionDetailResponses;
    private Long createdAt;
    private Long updatedAt;

}