package com.indonesianbank.loanapp.service.impl;

import com.indonesianbank.loanapp.constant.ApprovalStatus;
import com.indonesianbank.loanapp.entity.InstalmentType;
import com.indonesianbank.loanapp.entity.LoanType;
import com.indonesianbank.loanapp.entity.Transaction;
import com.indonesianbank.loanapp.model.request.ApproveTransactionRequest;
import com.indonesianbank.loanapp.model.request.TransactionRequest;
import com.indonesianbank.loanapp.model.response.TransactionResponse;
import com.indonesianbank.loanapp.repository.TransactionRepository;
import com.indonesianbank.loanapp.service.InstalmentTypeService;
import com.indonesianbank.loanapp.service.LoanTypeService;
import com.indonesianbank.loanapp.service.TransactionDetailService;
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
    private final TransactionDetailService transactionDetailRepository;
    private final TransactionDetailService transactionDetailService;
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

    @Override
    public TransactionResponse findTransactionById(String id) {
        Transaction transaction = transactionRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Transaction not found!"));
        return TransactionResponse.builder()
                .id(transaction.getId())
                .loanTypeId(transaction.getLoanType().getId())
                .instalmentTypeId(transaction.getInstalmentType().getId())
                .customerId(null)
                .nominal(transaction.getNominal())
                .approvedAt(transaction.getApprovedAt())
                .approvedBy(transaction.getApprovedBy())
                .approvalStatus(transaction.getApprovalStatus())
                .transactionDetailResponses(List.of())
                .createdAt(transaction.getCreatedAt())
                .updatedAt(transaction.getUpdatedAt())
                .build();
    }


    @Override
    public TransactionResponse approveTransaction(
            String id, ApproveTransactionRequest approveTransactionRequest
    ) {
        Transaction transaction = transactionRepository
                .findById(approveTransactionRequest.getLoanTransactionId())
                .orElseThrow(() -> new EntityNotFoundException("Transaction not found!"));

        transaction.setApprovedAt(new Date().getTime());
        transaction.setApprovedBy("Naufal Zaul Karim");
        transaction.setApprovalStatus(ApprovalStatus.APPROVED);
        transaction.setTransactionDetails(null);
        transaction.setUpdatedAt(new Date().getTime());


        //        List<TransactionDetail> transactionDetailList = transaction
        //                .getTransactionDetails()
        //                .stream().map(
        //                        transactionDetail -> TransactionDetail.builder()
        //                                .transactionDate(new Date().getTime())
        //                                .nominal(transactionDetail.getNominal())
        //                                .loanStatus(LoanStatus.PAID)
        //                                .createdAt(new Date().getTime())
        //                                .build()
        //                ).toList();

        //        transactionDetailService.createBulk(transactionDetailList);
        //        transaction.setTransactionDetails(transactionDetailList);

        //        List<TransactionDetailResponse> detailResponses = transactionDetailList
        //                .stream().map(
        //                        detailResponse ->
        //                                TransactionDetailResponse.builder()
        //                                        .id(detailResponse.getId())
        //                                        .transactionDate(detailResponse.getTransactionDate())
        //                                        .nominal(detailResponse.getNominal())
        //                                        .loanStatus(detailResponse.getLoanStatus())
        //                                        .createdAt(detailResponse.getCreatedAt())
        //                                        .updatedAt(detailResponse.getUpdatedAt())
        //                                        .build()
        //                ).toList();

        transactionRepository.saveAndFlush(transaction);
        return TransactionResponse.builder()
                .id(transaction.getId())
                .loanTypeId(transaction.getLoanType().getId())
                .instalmentTypeId(transaction.getInstalmentType().getId())
                .customerId(null)
                .nominal(transaction.getNominal())
                .approvedAt(transaction.getApprovedAt())
                .approvedBy(transaction.getApprovedBy())
                .approvalStatus(transaction.getApprovalStatus())
                .transactionDetailResponses(List.of())
                .createdAt(transaction.getCreatedAt())
                .updatedAt(transaction.getUpdatedAt())
                .build();
    }
}
