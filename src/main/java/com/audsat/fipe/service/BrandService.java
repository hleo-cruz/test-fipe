package com.audsat.fipe.service;

import com.audsat.fipe.client.brand.BrandClient;
import com.audsat.fipe.dto.BrandResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandService {

    @Autowired
    private BrandClient client;
    public List<BrandResponseDTO> findBrands() {
        return client.findBrands().stream()
                .map(BrandResponseDTO::new).collect(Collectors.toList());
    }

}
