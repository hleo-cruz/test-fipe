package com.audsat.fipe.controller;

import com.audsat.fipe.client.vehicle.VehicleClient;
import com.audsat.fipe.dto.VehicleResponseDTO;
import com.audsat.fipe.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/vehicle")
public class VehicleController {

    @Autowired
    private VehicleService service;


    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/brand/{brandId}")
    public ResponseEntity<List<VehicleResponseDTO>> findVehicleByBrands(@PathVariable("brandId") Long brandId) {
        return ResponseEntity.ok(service.findVehicleByBrands(brandId));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/brand/{brandId}/model/{modelId}")
    public Object findVehicleYearByModelFipe(@PathVariable("brandId") Long brandId, @PathVariable("modelId") Long modelId) {
        return service.findVehicleYearByModelFipe(brandId, modelId);
    }

}
