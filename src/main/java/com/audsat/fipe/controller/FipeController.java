package com.audsat.fipe.controller;

import com.audsat.fipe.dto.FipeResponseDTO;
import com.audsat.fipe.service.FipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/fipe/vehicle")
public class FipeController {

    @Autowired
    private FipeService service;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/brand/{brandId}/model/{modelId}/year/{yearId}")
    public ResponseEntity<FipeResponseDTO> findVehicleFipe(@PathVariable("brandId") Long brandId, @PathVariable("modelId") Long modelId, @PathVariable("yearId") String yearId) {
        return ResponseEntity.ok(service.findVehicleFipe(brandId, modelId, yearId));
    }
}
