package com.audsat.fipe.service;

import com.audsat.fipe.client.vehicle.VehicleClient;
import com.audsat.fipe.dto.VehicleResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleService {

    @Autowired
    private VehicleClient client;

    public List<VehicleResponseDTO> findVehicleByBrands(Long brandId) {
        return client.findVehicleByBrands(brandId).stream()
                .map(VehicleResponseDTO::new).collect(Collectors.toList());
    }

    public Object findVehicleYearByModelFipe(Long brandId, Long modelId) {
        return client.findVehicleYearByModelFipe(brandId, modelId);
    }

}
