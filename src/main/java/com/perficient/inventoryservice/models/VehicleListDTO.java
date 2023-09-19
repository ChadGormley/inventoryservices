package com.perficient.inventoryservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class VehicleListDTO {
    List<VehicleDTO> vehicles;
}
