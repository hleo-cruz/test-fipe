package com.audsat.fipe.controller;

import com.audsat.fipe.dto.BrandResponseDTO;
import com.audsat.fipe.service.BrandService;
import com.audsat.fipe.service.FipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/brand")
public class BrandController {

    @Autowired
    private BrandService service;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public ResponseEntity<List<BrandResponseDTO>> findBrands() {
        return ResponseEntity.ok(service.findBrands());
    }



}
