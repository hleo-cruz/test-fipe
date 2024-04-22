package com.audsat.fipe.dto;

import com.audsat.fipe.enumeration.VehicleType;
import com.audsat.fipe.model.FipeModel;
import lombok.Data;

@Data
public class FipeResponseDTO {

    private VehicleType type;
    private String price;
    private String brand;
    private String model;
    private String modelYear;
    private String fuel;
    private String codeFipe;
    private String referenceMonth;
    private String fuelAcronym;

    public FipeResponseDTO(FipeModel model) {
        this.type = model.getType();
        this.price = model.getPrice();
        this.brand = model.getBrand();
        this.model = model.getModel();
        this.modelYear = model.getModelYear();
        this.fuel = model.getFuel();
        this.referenceMonth = model.getReferenceMonth();
        this.fuelAcronym = model.getFuelAcronym();
    }
}
