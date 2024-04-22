package com.audsat.fipe.client.brand;

import com.audsat.fipe.client.UrlIntegration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BrandUrl extends UrlIntegration {

    @Value("${http.client.vehicles.get-brands}")
    private String getBrands;

    public String brands() {
        return this.baseUrl.concat(getBrands);
    }

}
