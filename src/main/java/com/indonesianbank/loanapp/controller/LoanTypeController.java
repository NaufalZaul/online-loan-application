package com.indonesianbank.loanapp.controller;


import com.indonesianbank.loanapp.constant.APIBash;
import com.indonesianbank.loanapp.entity.LoanType;
import com.indonesianbank.loanapp.model.request.LoanTypeCreateRequest;
import com.indonesianbank.loanapp.model.request.LoanTypeUpdateRequest;
import com.indonesianbank.loanapp.model.response.CommonResponse;
import com.indonesianbank.loanapp.service.LoanTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(APIBash.LOAN_PATH)
@RequiredArgsConstructor
public class LoanTypeController {

    private final LoanTypeService loanTypeService;

    @PostMapping
    public ResponseEntity<CommonResponse<LoanType>> createLoanType(
            @RequestBody LoanTypeCreateRequest loanTypeCreateRequest
    ) {
        LoanType loanType = loanTypeService.createLoanType(loanTypeCreateRequest);
        CommonResponse<LoanType> commonResponse = CommonResponse
                .<LoanType>builder()
                .message(APIBash.CREATE_LOAN_MESSAGE)
                .data(loanType)
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(commonResponse);
    }

    @GetMapping
    public ResponseEntity<CommonResponse<List<LoanType>>> findAllLoanType() {
        List<LoanType> loanTypeList = loanTypeService.findAllLoanType();
        CommonResponse<List<LoanType>> commonResponse = CommonResponse
                .<List<LoanType>>builder()
                .message(APIBash.FOUND_LOAN_MESSAGE)
                .data(loanTypeList)
                .build();
        return ResponseEntity.ok(commonResponse);
    }

    @GetMapping(APIBash.LOAN_BY_ID_PATH)
    public ResponseEntity<CommonResponse<LoanType>> findLoanTypeById(@PathVariable String id) {
        LoanType loanType = loanTypeService.findLoanTypeById(id);
        CommonResponse<LoanType> commonResponse = CommonResponse
                .<LoanType>builder()
                .message(APIBash.FOUND_LOAN_MESSAGE)
                .data(loanType)
                .build();
        return ResponseEntity.ok(commonResponse);
    }

    @PutMapping
    public ResponseEntity<CommonResponse<LoanType>> updateLoanType(
            @RequestBody LoanTypeUpdateRequest loanTypeUpdateRequest
    ) {
        LoanType loanType = loanTypeService.updateLoanType(loanTypeUpdateRequest);
        CommonResponse<LoanType> commonResponse = CommonResponse
                .<LoanType>builder()
                .message(APIBash.UPDATE_LOAN_MESSAGE)
                .data(loanType)
                .build();
        return ResponseEntity.ok(commonResponse);
    }

    @DeleteMapping(APIBash.LOAN_BY_ID_PATH)
    public ResponseEntity<CommonResponse<String>> deleteLoanType(@PathVariable String id) {
        loanTypeService.deleteLoanType(id);
        CommonResponse<String> commonResponse = CommonResponse
                .<String>builder()
                .message(APIBash.DELETE_LOAN_MESSAGE)
                .build();
        return ResponseEntity.ok(commonResponse);
    }

}
