package com.audsat.fipe.service;

import com.audsat.fipe.client.fipe.FipeClient;
import com.audsat.fipe.dto.FipeResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FipeService {

    @Autowired
    private FipeClient client;

    public FipeResponseDTO findVehicleFipe(Long brandId, Long modelId, String yearId) {
        return client.findVehicleFipe(brandId, modelId, yearId)
                .map(FipeResponseDTO::new).get();
    }
}
