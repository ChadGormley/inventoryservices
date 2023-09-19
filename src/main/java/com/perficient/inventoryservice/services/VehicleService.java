package com.perficient.inventoryservice.services;

import com.perficient.inventoryservice.domain.Vehicle;
import com.perficient.inventoryservice.models.VehicleDTO;

import java.util.List;

public interface VehicleService {
    List<VehicleDTO> getVehicleList();

    VehicleDTO findVehicleByVin(String vin);

    VehicleDTO createNewVehicle(VehicleDTO vehicleDTO);
}
