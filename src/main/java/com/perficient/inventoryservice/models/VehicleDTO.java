package com.perficient.inventoryservice.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDTO {
    private Long id;
    private String vin;
    private String imgName;
    private String make;
    private String model;
    private String year;
    private String type;
    private String mileage;
    private String price;
    private String color;

    @JsonProperty("vehicle_url")
    private String vehicleUrl;
}
