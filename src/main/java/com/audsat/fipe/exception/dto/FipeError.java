package com.audsat.fipe.exception.dto;

import lombok.Data;

@Data
public class FipeError extends CustomError{

    private Integer code;
    private String message;
}
