package com.indonesianbank.loanapp.service;

import com.indonesianbank.loanapp.entity.LoanType;
import com.indonesianbank.loanapp.model.request.LoanTypeCreateRequest;
import com.indonesianbank.loanapp.model.request.LoanTypeUpdateRequest;

import java.util.List;

public interface LoanTypeService {
    LoanType createLoanType(LoanTypeCreateRequest loanTypeCreateRequest);
    LoanType findLoanTypeById(String id);
    List<LoanType> findAllLoanType();
    LoanType updateLoanType(LoanTypeUpdateRequest loanTypeUpdateRequest);
    void deleteLoanType(String id);
}
