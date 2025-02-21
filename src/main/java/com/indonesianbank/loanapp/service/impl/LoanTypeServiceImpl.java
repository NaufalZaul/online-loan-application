package com.indonesianbank.loanapp.service.impl;

import com.indonesianbank.loanapp.entity.LoanType;
import com.indonesianbank.loanapp.model.request.LoanTypeCreateRequest;
import com.indonesianbank.loanapp.model.request.LoanTypeUpdateRequest;
import com.indonesianbank.loanapp.repository.LoanTypeRepository;
import com.indonesianbank.loanapp.service.LoanTypeService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoanTypeServiceImpl implements LoanTypeService {

    private final LoanTypeRepository loanTypeRepository;

    @Override
    public LoanType createLoanType(LoanTypeCreateRequest loanTypeCreateRequest) {
        LoanType loanType =
                LoanType.builder().type(loanTypeCreateRequest.getType()).maxLoan(loanTypeCreateRequest.getMaxLoan()).build();
        return loanTypeRepository.save(loanType);
    }

    @Override
    public LoanType findLoanTypeById(String id) {
        return loanTypeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Loan type not found!"));
    }

    @Override
    public List<LoanType> findAllLoanType() {
        return loanTypeRepository.findAll();
    }

    @Override
    public LoanType updateLoanType(LoanTypeUpdateRequest loanTypeUpdateRequest) {
        return loanTypeRepository
                .findById(loanTypeUpdateRequest.getId())
                .map(loanType -> {
                    loanType.setType(loanTypeUpdateRequest.getType());
                    loanType.setMaxLoan(loanTypeUpdateRequest.getMaxLoan());
                    return loanTypeRepository.saveAndFlush(loanType);
                }).orElseThrow(() -> new EntityNotFoundException("Loan Type not found!"));
    }

    @Override
    public void deleteLoanType(String id) {
        if (!loanTypeRepository.existsById(id)) {
            throw new EntityNotFoundException("Loan type not found!");
        }

        loanTypeRepository.deleteById(id);
    }
}
