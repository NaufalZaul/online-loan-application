package com.indonesianbank.loanapp.controller;

import com.indonesianbank.loanapp.constant.APIBash;
import com.indonesianbank.loanapp.model.request.TransactionRequest;
import com.indonesianbank.loanapp.model.response.CommonResponse;
import com.indonesianbank.loanapp.model.response.TransactionResponse;
import com.indonesianbank.loanapp.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(APIBash.TRANSACTION_PATH)
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping
    public ResponseEntity<CommonResponse<TransactionResponse>> requestLoan(
            @RequestBody TransactionRequest transactionRequest
    ) {
        TransactionResponse transactionResponse = transactionService.requestLoan(transactionRequest);
        CommonResponse<TransactionResponse> commonResponse = CommonResponse
                .<TransactionResponse>builder()
                .message(APIBash.TRANSACTION_MESSAGE)
                .data(transactionResponse)
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(commonResponse);
    }

}
