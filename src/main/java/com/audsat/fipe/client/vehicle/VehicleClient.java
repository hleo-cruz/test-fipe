package com.audsat.fipe.client.vehicle;

import com.audsat.fipe.client.DFortunaRestTemplateClient;
import com.audsat.fipe.client.UrlIntegration;
import com.audsat.fipe.model.VehicleModel;
import com.google.common.collect.ImmutableMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Component
public class VehicleClient extends DFortunaRestTemplateClient {

    @Autowired
    private VehicleUrl urlIntegration;

    public List<VehicleModel> findVehicleByBrands(final Long brandId) {

        final ImmutableMap<String, Object> param = ImmutableMap.of(
                "brandId", brandId);

        final String url = UriComponentsBuilder
                .fromHttpUrl(urlIntegration.modelsByBrand())
                .buildAndExpand(param)
                .toUriString();

        final ImmutableMap<String, Object> headerValues = ImmutableMap.of("Content-type", APPLICATION_JSON_VALUE);
        final HttpHeaders headers = headers(headerValues);

        final VehicleModel[] response = request(url, GET, headers, VehicleModel[].class).getBody();
        return List.of(response);

    }

    public Object findVehicleYearByModelFipe(Long brandId, Long modelId) {


        final ImmutableMap<String, Object> param = ImmutableMap.of(
                "brandId", brandId,
                "modelId", modelId);

        final String url = UriComponentsBuilder
                .fromHttpUrl(urlIntegration.yearByModel())
                .buildAndExpand(param)
                .toUriString();

        final ImmutableMap<String, Object> headerValues = ImmutableMap.of("Content-type", APPLICATION_JSON_VALUE);
        final HttpHeaders headers = headers(headerValues);

        return request(url, GET, headers, Object.class).getBody();

    }

}
