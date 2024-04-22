package com.audsat.fipe.client.vehicle;

import com.audsat.fipe.client.UrlIntegration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class VehicleUrl extends UrlIntegration {


    @Value("${http.client.vehicles.get-models-by-brand}")
    private String getModelsByBrand;

    @Value("${http.client.vehicles.get-years-by-model}")
    private String getYearByModel;


    public String modelsByBrand() {
        return baseUrl.concat(getModelsByBrand);
    }

    public String yearByModel() {
        return baseUrl.concat(getYearByModel);
    }
}
