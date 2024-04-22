package com.audsat.fipe.model;

import com.audsat.fipe.enumeration.VehicleType;
import lombok.Data;

@Data
public class FipeModel {

    private VehicleType type;
    private String price;
    private String brand;
    private String model;
    private String modelYear;
    private String fuel;
    private String codeFipe;
    private String referenceMonth;
    private String fuelAcronym;
}
