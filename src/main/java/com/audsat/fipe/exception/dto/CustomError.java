package com.audsat.fipe.exception.dto;

import lombok.Data;

@Data
public class CustomError {

    private String title;
    private String message;

    public CustomError() {
        this.title = "Ocorreu um erro";
        this.message = "Ocorreu um erro genérico no processamento da sua solicitação.";
    }
}
