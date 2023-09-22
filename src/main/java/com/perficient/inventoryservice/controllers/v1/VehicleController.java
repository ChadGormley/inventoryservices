package com.perficient.inventoryservice.controllers.v1;

import com.perficient.inventoryservice.domain.Vehicle;
import com.perficient.inventoryservice.models.VehicleDTO;
import com.perficient.inventoryservice.models.VehicleListDTO;
import com.perficient.inventoryservice.services.VehicleService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/v1/vehicles")
public class VehicleController {
    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping
    public ResponseEntity<VehicleListDTO> getAllVehicles() throws InterruptedException {
        Thread.sleep(1000);
        return new ResponseEntity<VehicleListDTO>(
                new VehicleListDTO(vehicleService.getVehicleList()), HttpStatus.OK
        );
    }

    @GetMapping("/{vin}")
    public ResponseEntity<VehicleDTO> getVehicleByVin(@PathVariable String vin) {
        return new ResponseEntity<VehicleDTO>(
          vehicleService.findVehicleByVin(vin), HttpStatus.OK
        );
    }

    @PostMapping
    public ResponseEntity<VehicleDTO> saveNewVehicle(@RequestBody VehicleDTO vehicleDTO) throws InterruptedException {
        Thread.sleep(1000);
        return new ResponseEntity<VehicleDTO>(
                vehicleService.createNewVehicle(vehicleDTO), HttpStatus.CREATED
        );
    }
}
