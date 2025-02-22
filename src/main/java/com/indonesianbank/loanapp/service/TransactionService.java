package com.indonesianbank.loanapp.service;

import com.indonesianbank.loanapp.model.request.TransactionRequest;
import com.indonesianbank.loanapp.model.response.TransactionResponse;

public interface TransactionService {
    TransactionResponse requestLoan(TransactionRequest transactionRequest);

    TransactionResponse findTransactionById(String id);
}
