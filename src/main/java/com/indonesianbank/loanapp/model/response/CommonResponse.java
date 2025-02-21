package com.indonesianbank.loanapp.model.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CommonResponse<T> {
    private String message;
    private T data;
}
