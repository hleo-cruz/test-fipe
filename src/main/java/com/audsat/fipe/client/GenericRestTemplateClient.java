package com.audsat.fipe.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public abstract class GenericRestTemplateClient {

    Logger logger = LoggerFactory.getLogger(GenericRestTemplateClient.class);

    @Autowired
    private RestTemplate restTemplate;

    protected abstract <T> T getResponseBodyError(ResponseEntity responseEntity) throws Exception;


    protected HttpHeaders headers(Map<String, Object> headerValues) {

        final HttpHeaders headers = new HttpHeaders();

        headerValues.forEach((key, value) -> {

            if (value instanceof MediaType) {
                headers.setContentType((MediaType) value);
            }
            headers.set(key, String.valueOf(value));
        });

        return headers;
    }

    protected <R> ResponseEntity<R> request(String url, HttpMethod httpMethod, HttpHeaders headers, Class<R> responseBody) {

        ResponseEntity<R> response = null;

        final HttpEntity httpEntity = new HttpEntity(headers);

        logRequest(url, httpMethod, headers);



            response = restTemplate.exchange(url, httpMethod, httpEntity, responseBody);
            logResponse(url, response);

            return response;



    }

    protected ResponseEntity<Void> request(String url, HttpMethod httpMethod, HttpHeaders headers) {

        ResponseEntity<Void> response = null;
        final HttpEntity httpEntity = new HttpEntity(headers);

        logRequest(url, httpMethod, headers);



            response = restTemplate.exchange(url, httpMethod, httpEntity, Void.class);
            logResponse(url, response);

            return response;


    }

    protected <R, B> ResponseEntity<R> requestWithBody(B body, String url, HttpMethod httpMethod, HttpHeaders headers, Class<R> responseBody) {

        ResponseEntity<R> response = null;
        final HttpEntity httpEntity = new HttpEntity(body, headers);



            response = restTemplate.exchange(url, httpMethod, httpEntity, responseBody);
            logResponse(url, response);

            return response;


    }

    protected <B> ResponseEntity requestWithBody(B body, String url, HttpMethod httpMethod, HttpHeaders headers) {

        final HttpEntity httpEntity = new HttpEntity(body, headers);


            final ResponseEntity response = restTemplate.exchange(url, httpMethod, httpEntity, String.class);
            logResponse(url, response);

            return response;


    }

    private void logRequest(final String url, final HttpMethod httpMethod, final HttpHeaders headers) {
        final long threadId = Thread.currentThread().getId();
        final StringBuilder sb = new StringBuilder();

        sb.append("\n --------------------------------------------------------------------------------------- \n");
        sb.append(String.format("| #################################### REQUEST - %s #################################### \n", threadId));
        sb.append(String.format("| URL - %s \n", url));
        sb.append(String.format("| HttpMethod - %s \n", httpMethod));

        if (headers != null) {
            sb.append("| Headers {                                                                |\n");
            headers.forEach((key, values) -> {
                if (!key.equals("Authorization")) {
                    sb.append(String.format("| %s - %s \n", key, values.stream().collect(Collectors.joining(","))));
                }
            });

            sb.append("|   }  \n");
        }

        sb.append(String.format("| #################################### REQUEST - %s #################################### \n", threadId));
        sb.append(" --------------------------------------------------------------------------------------- \n");

        logger.info(sb.toString());
    }

    private void logResponse(final String url, final ResponseEntity responseEntity) {
        final long threadId = Thread.currentThread().getId();
        final StringBuilder sb = new StringBuilder();

        sb.append("\n --------------------------------------------------------------------------------------- \n");
        sb.append(String.format("| #################################### RESPONSE - %s #################################### \n", threadId));

        sb.append(String.format("| URL - %s \n", url));
        sb.append(String.format("| HttpStatus - %s \n", responseEntity.getStatusCode()));
        sb.append(String.format("| HasBody - %s \n", responseEntity.hasBody()));

        sb.append(String.format("| #################################### RESPONSE - %s #################################### \n", threadId));
        sb.append(" --------------------------------------------------------------------------------------- \n");

        logger.info(sb.toString());
    }
}