package com.indonesianbank.loanapp.service.impl;

import com.indonesianbank.loanapp.constant.ApprovalStatus;
import com.indonesianbank.loanapp.entity.InstalmentType;
import com.indonesianbank.loanapp.entity.LoanType;
import com.indonesianbank.loanapp.entity.Transaction;
import com.indonesianbank.loanapp.model.request.TransactionRequest;
import com.indonesianbank.loanapp.model.response.TransactionResponse;
import com.indonesianbank.loanapp.repository.TransactionRepository;
import com.indonesianbank.loanapp.service.InstalmentTypeService;
import com.indonesianbank.loanapp.service.LoanTypeService;
import com.indonesianbank.loanapp.service.TransactionService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final LoanTypeService loanTypeService;
    private final InstalmentTypeService instalmentTypeService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public TransactionResponse requestLoan(TransactionRequest transactionRequest) {
        LoanType loanType = loanTypeService
                .findLoanTypeById(transactionRequest.getLoanType().getId());
        InstalmentType instalmentType = instalmentTypeService
                .findInstalmentTypeById(transactionRequest.getInstalmentType().getId());

        Transaction transaction = Transaction.builder()
                .loanType(loanType)
                .instalmentType(instalmentType)
                .customer(null)
                .nominal(transactionRequest.getNominal())
                .approvedAt(null)
                .approvedBy(null)
                .approvalStatus(null)
                .transactionDetails(List.of())
                .createdAt(new Date().getTime())
                .updatedAt(null)
                .build();

        transactionRepository.save(transaction);

        return TransactionResponse.builder()
                .id(transaction.getId())
                .loanTypeId(loanType.getId())
                .instalmentTypeId(instalmentType.getId())
                .customerId(null)
                .nominal(transaction.getNominal())
                .approvedAt(null)
                .approvedBy(null)
                .approvalStatus(null)
                .transactionDetailResponses(null)
                .createdAt(transaction.getCreatedAt())
                .updatedAt(null)
                .build();
    }

}
