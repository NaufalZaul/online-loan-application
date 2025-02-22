package com.indonesianbank.loanapp.service.impl;

import com.indonesianbank.loanapp.entity.TransactionDetail;
import com.indonesianbank.loanapp.repository.TransactionDetailRepository;
import com.indonesianbank.loanapp.service.TransactionDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionDetailServiceImpl implements TransactionDetailService {
    private final TransactionDetailRepository transactionDetailRepository;

    @Override
    public List<TransactionDetail> createBulk(List<TransactionDetail> transactionDetails) {
        return transactionDetailRepository.saveAllAndFlush(transactionDetails);
    }
}
