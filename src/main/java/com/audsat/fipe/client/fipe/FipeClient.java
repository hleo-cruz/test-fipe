package com.audsat.fipe.client.fipe;

import com.audsat.fipe.client.DFortunaRestTemplateClient;
import com.audsat.fipe.model.FipeModel;
import com.google.common.collect.ImmutableMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Component
public class FipeClient extends DFortunaRestTemplateClient {

    @Autowired
    private FipeUrl urlIntegration;

    public Optional<FipeModel> findVehicleFipe(final Long brandId, final Long modelId, final String yearId) {


        final ImmutableMap<String, Object> param = ImmutableMap.of(
                "brandId", brandId,
                "modelId", modelId,
                "yearId", yearId);

        final String url = UriComponentsBuilder
                .fromHttpUrl(urlIntegration.vehicleFipe())
                .buildAndExpand(param)
                .toUriString();

        final ImmutableMap<String, Object> headerValues = ImmutableMap.of("Content-type", APPLICATION_JSON_VALUE);
        final HttpHeaders headers = headers(headerValues);

        final FipeModel response = request(url, GET, headers, FipeModel.class).getBody();
        return Optional.of(response);

    }

}
