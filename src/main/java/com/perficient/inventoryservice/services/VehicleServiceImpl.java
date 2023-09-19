package com.perficient.inventoryservice.services;

import com.perficient.inventoryservice.domain.Vehicle;
import com.perficient.inventoryservice.mapper.VehicleMapper;
import com.perficient.inventoryservice.models.VehicleDTO;
import com.perficient.inventoryservice.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements VehicleService {
    private final VehicleRepository vehicleRepository;
    private final VehicleMapper vehicleMapper;

    public VehicleServiceImpl(VehicleRepository vehicleRepository, VehicleMapper vehicleMapper) {
        this.vehicleRepository = vehicleRepository;
        this.vehicleMapper = vehicleMapper;
    }

    @Override
    public List<VehicleDTO> getVehicleList() {

        return vehicleRepository.findAll()
                .stream()
                //.map(vehicleMapper::vehicleToVehicleDTO)
                .map(vehicle -> {
                    VehicleDTO vehicleDTO = vehicleMapper.vehicleToVehicleDTO(vehicle);
                    vehicleDTO.setVehicleUrl("/api/v1/vehicles/" + vehicle.getId());
                    return vehicleDTO;
                })
                .collect(Collectors.toList());
    }

    @Override
    public VehicleDTO findVehicleByVin(String vin) {
        Vehicle vehicle = vehicleRepository.findByVin(vin);
        VehicleDTO vehicleDTO = vehicleMapper.vehicleToVehicleDTO(vehicle);
        vehicleDTO.setVehicleUrl("/api/v1/vehicles/" + vehicle.getId());

        return vehicleDTO;
    }

    @Override
    public VehicleDTO createNewVehicle(VehicleDTO vehicleDTO) {
        Vehicle vehicle = vehicleMapper.vehicleDTOToVehicle(vehicleDTO);
        Vehicle savedVehicle = vehicleRepository.save(vehicle);
        VehicleDTO savedVehicleDTO = vehicleMapper.vehicleToVehicleDTO(savedVehicle);
        savedVehicleDTO.setVehicleUrl("/api/v1/vehicles/" + savedVehicle.getId());

        return savedVehicleDTO;
    }
}
