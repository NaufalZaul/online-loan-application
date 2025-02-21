package com.indonesianbank.loanapp.service.impl;

import com.indonesianbank.loanapp.constant.EInstalmentType;
import com.indonesianbank.loanapp.entity.InstalmentType;
import com.indonesianbank.loanapp.model.request.InstalmentTypeCreateRequest;
import com.indonesianbank.loanapp.model.request.InstalmentTypeUpdateRequest;
import com.indonesianbank.loanapp.repository.InstalmentTypeRepository;
import com.indonesianbank.loanapp.service.InstalmentTypeService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InstalmentTypeServiceImpl implements InstalmentTypeService {

    private final InstalmentTypeRepository instalmentTypeRepository;

    @Override
    public InstalmentType createInstalmentType(InstalmentTypeCreateRequest instalmentTypeCreateRequest) {
        InstalmentType instalmentType = InstalmentType.builder()
                .instalmentType(EInstalmentType.valueOf(instalmentTypeCreateRequest.getInstalmentType()))
                .build();
        return instalmentTypeRepository.save(instalmentType);
    }

    @Override
    public InstalmentType findInstalmentTypeById(String id) {
        return instalmentTypeRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Instalment type not found!"));
    }

    @Override
    public List<InstalmentType> findAllInstalmentType() {
        return instalmentTypeRepository.findAll();
    }

    @Override
    public InstalmentType updateInstalmentType(
            InstalmentTypeUpdateRequest instalmentTypeUpdateRequest) {
        return instalmentTypeRepository
                .findById(instalmentTypeUpdateRequest.getId())
                .map(instalmentType -> {
                    instalmentType.setInstalmentType(
                            EInstalmentType.valueOf(instalmentTypeUpdateRequest.getInstalmentType()));
                    return instalmentTypeRepository.saveAndFlush(instalmentType);
                })
                .orElseThrow(() -> new EntityNotFoundException("Instalment Type not found!"));
    }


    @Override
    public void deleteInstalmentType(String id) {
        if (!instalmentTypeRepository.existsById(id)) {
            throw new EntityNotFoundException("Instalment not found!");
        }
        instalmentTypeRepository.deleteById(id);
    }
}
