package com.indonesianbank.loanapp.service;

import com.indonesianbank.loanapp.entity.InstalmentType;
import com.indonesianbank.loanapp.model.request.InstalmentTypeCreateRequest;
import com.indonesianbank.loanapp.model.request.InstalmentTypeUpdateRequest;

import java.util.List;

public interface InstalmentTypeService {
    InstalmentType createInstalmentType(InstalmentTypeCreateRequest instalmentTypeCreateRequest);

    InstalmentType findInstalmentTypeById(String id);

    List<InstalmentType> findAllInstalmentType();

    InstalmentType updateInstalmentType(InstalmentTypeUpdateRequest instalmentTypeUpdateRequest);

    void deleteInstalmentType(String id);
}
