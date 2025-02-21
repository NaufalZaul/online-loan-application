package com.indonesianbank.loanapp.model.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class InstalmentTypeUpdateRequest {
    private String id;
    private String instalmentType;
}


