package com.perficient.inventoryservice.repository;

import com.perficient.inventoryservice.domain.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    Vehicle findByVin(String vin);
}
