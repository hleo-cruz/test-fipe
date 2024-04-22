package com.audsat.fipe.client.brand;

import com.audsat.fipe.client.DFortunaRestTemplateClient;
import com.audsat.fipe.client.UrlIntegration;
import com.audsat.fipe.model.BrandModel;
import com.google.common.collect.ImmutableMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Component
public class BrandClient extends DFortunaRestTemplateClient {

    @Autowired
    private BrandUrl urlIntegration;

    public List<BrandModel> findBrands() {

        final String url = urlIntegration.brands();

        final ImmutableMap<String, Object> headerValues = ImmutableMap.of("Content-type", APPLICATION_JSON_VALUE);
        final HttpHeaders headers = headers(headerValues);

        final BrandModel[] response = request(url, GET, headers, BrandModel[].class).getBody();

        return List.of(response);

    }
}
