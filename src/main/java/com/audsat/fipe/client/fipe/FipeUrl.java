package com.audsat.fipe.client.fipe;

import com.audsat.fipe.client.UrlIntegration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FipeUrl extends UrlIntegration {


    @Value("${http.client.vehicles.get-vehicle-fipe}")
    private String getVehicleFipe;

    public String vehicleFipe() {
        return baseUrl.concat(getVehicleFipe);
    }
}
