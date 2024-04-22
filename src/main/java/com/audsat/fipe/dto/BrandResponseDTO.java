package com.audsat.fipe.dto;

import com.audsat.fipe.model.BrandModel;
import lombok.Data;

@Data
public class BrandResponseDTO {

    private String code;
    private String name;

    public BrandResponseDTO(BrandModel model) {
        this.code = model.getCode();
        this.name = model.getName();
    }
}
