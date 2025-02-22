package com.indonesianbank.loanapp.service;

import com.indonesianbank.loanapp.entity.TransactionDetail;

import java.util.List;

public interface TransactionDetailService {
    List<TransactionDetail> createBulk(List<TransactionDetail> transactionDetails);
}
