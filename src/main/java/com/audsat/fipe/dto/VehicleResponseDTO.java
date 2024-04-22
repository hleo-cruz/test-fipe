package com.audsat.fipe.dto;

import com.audsat.fipe.model.VehicleModel;
import lombok.Data;

@Data
public class VehicleResponseDTO {

    private String code;
    private String name;

    public VehicleResponseDTO(VehicleModel model) {
        this.code = model.getCode();
        this.name = model.getName();
    }
}
