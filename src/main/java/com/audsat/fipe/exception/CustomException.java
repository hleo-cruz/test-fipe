package com.audsat.fipe.exception;

import com.audsat.fipe.exception.dto.CustomError;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class CustomException extends RuntimeException{

    private CustomError error;
    private HttpStatus status;

    public CustomException() {
        this.error = new CustomError();
        this.status = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    public CustomException(CustomError error, HttpStatus status) {
        this.error = error;
        this.status = status;
    }
}
