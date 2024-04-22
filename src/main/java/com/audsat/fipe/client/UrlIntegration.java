package com.audsat.fipe.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UrlIntegration {

    @Value("${http.client.vehicles.base-url}")
    protected String baseUrl;

}
