package com.audsat.fipe.enumeration;

public enum VehicleType {

    NAO_DEFINIDO(0), CARS(1), MOTORCYCLE(2), TRUCKS(3);
    private int code;
    private VehicleType(int code) {
        this.code = code;
    }

    public static VehicleType findByCode(int code) {
        for(VehicleType type: values()) {
            if(type.code == code) {
                return type;
            }
        }
        return NAO_DEFINIDO;
    }
}
