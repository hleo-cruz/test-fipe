package com.audsat.fipe.client;

import com.audsat.fipe.exception.dto.CustomError;
import com.audsat.fipe.exception.dto.FipeError;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class DFortunaRestTemplateClient extends GenericRestTemplateClient {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    protected CustomError getResponseBodyError(ResponseEntity responseEntity) throws JsonProcessingException {
        final Object body = responseEntity.getBody();
        return objectMapper.readValue(String.valueOf(body), FipeError.class);
    }
}
