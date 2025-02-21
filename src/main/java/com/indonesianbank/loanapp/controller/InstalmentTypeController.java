package com.indonesianbank.loanapp.controller;

import com.indonesianbank.loanapp.constant.APIBash;
import com.indonesianbank.loanapp.entity.InstalmentType;
import com.indonesianbank.loanapp.model.request.InstalmentTypeCreateRequest;
import com.indonesianbank.loanapp.model.request.InstalmentTypeUpdateRequest;
import com.indonesianbank.loanapp.model.response.CommonResponse;
import com.indonesianbank.loanapp.service.InstalmentTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(APIBash.INSTALMENT_TYPE_PATH)
@RequiredArgsConstructor
public class InstalmentTypeController {

    private final InstalmentTypeService instalmentTypeService;

    @PostMapping
    public ResponseEntity<CommonResponse<InstalmentType>> createInstalmentType(
            @RequestBody InstalmentTypeCreateRequest instalmentTypeCreateRequest
    ) {
        InstalmentType instalmentType = instalmentTypeService.createInstalmentType(instalmentTypeCreateRequest);

        CommonResponse<InstalmentType> commonResponse = CommonResponse
                .<InstalmentType>builder()
                .message(APIBash.CREATE_INSTALMENT_MESSAGE)
                .data(instalmentType)
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(commonResponse);
    }

    @GetMapping
    public ResponseEntity<CommonResponse<List<InstalmentType>>> findAllInstalmentType() {
        List<InstalmentType> instalmentTypeList = instalmentTypeService.findAllInstalmentType();
        CommonResponse<List<InstalmentType>> commonResponse = CommonResponse
                .<List<InstalmentType>>builder()
                .message(APIBash.FOUND_INSTALMENT_MESSAGE)
                .data(instalmentTypeList)
                .build();
        return ResponseEntity.ok(commonResponse);
    }

    @GetMapping(APIBash.INSTALMENT_TYPE_BY_ID_PATH)
    public ResponseEntity<CommonResponse<InstalmentType>> findInstalmentTypeById(
            @PathVariable String id
    ) {
        InstalmentType instalmentType = instalmentTypeService.findInstalmentTypeById(id);
        CommonResponse<InstalmentType> commonResponse = CommonResponse
                .<InstalmentType>builder()
                .message(APIBash.FOUND_INSTALMENT_MESSAGE)
                .data(instalmentType)
                .build();
        return ResponseEntity.ok(commonResponse);
    }

    @PutMapping
    public ResponseEntity<CommonResponse<InstalmentType>> updateInstalmentType(
            @RequestBody InstalmentTypeUpdateRequest instalmentTypeUpdateRequest
    ) {
        InstalmentType instalmentType = instalmentTypeService.updateInstalmentType(instalmentTypeUpdateRequest);

        CommonResponse<InstalmentType> commonResponse = CommonResponse
                .<InstalmentType>builder()
                .message(APIBash.UPDATE_INSTALMENT_MESSAGE)
                .data(instalmentType)
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(commonResponse);
    }

    @DeleteMapping(APIBash.INSTALMENT_TYPE_BY_ID_PATH)
    public ResponseEntity<CommonResponse<String>> deleteInstalmentType(@PathVariable String id){
        instalmentTypeService.deleteInstalmentType(id);
        CommonResponse<String> commonResponse = CommonResponse
                .<String>builder()
                .message(APIBash.DELETE_INSTALMENT_MESSAGE)
                .build();
        return ResponseEntity.ok(commonResponse);
    }
}
