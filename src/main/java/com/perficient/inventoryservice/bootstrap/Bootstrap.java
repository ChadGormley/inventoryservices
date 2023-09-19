package com.perficient.inventoryservice.bootstrap;

import com.perficient.inventoryservice.domain.Vehicle;
import com.perficient.inventoryservice.repository.VehicleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {
    private VehicleRepository vehicleRepository;

    public Bootstrap(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Vehicle vehicle1 = generateVehicle(
            "1111111111111",
            "hondaAccord",
            "Honda",
            "Accord",
            "2022",
            "Long-range",
            "35,000",
            "37,999",
            "blue"
        );
        vehicleRepository.save(vehicle1);

        Vehicle vehicle2 = generateVehicle(
            "2222222222222",
            "teslaModelS",
            "Tesla",
            "Model S",
            "2023",
            "Electric",
            "22,000",
            "52,999",
            "red"
        );
        vehicleRepository.save(vehicle2);

        Vehicle vehicle3 = generateVehicle(
            "3333333333333",
            "teslaWhite",
            "Tesla",
            "Model S",
            "2018",
            "Electric",
            "42,000",
            "32,999",
            "white"
        );
        vehicleRepository.save(vehicle3);

        Vehicle vehicle4 = generateVehicle(
                "4444444444444",
                "audiGold",
                "Audi",
                "eTron",
                "2023",
                "Chronos",
                "34,500",
                "62,999",
                "gold"
        );
        vehicleRepository.save(vehicle4);

        Vehicle vehicle5 = generateVehicle(
                "5555555555555",
                "bmwGold",
                "BMW",
                "3 Series",
                "2023",
                "328i Gran Turismo Xdrive",
                "42,000",
                "22,999",
                "gold"
        );
        vehicleRepository.save(vehicle5);

        Vehicle vehicle6 = generateVehicle(
                "6666666666666",
                "audiWhite",
                "Audi",
                "TT",
                "2014",
                "Quatro Premium",
                "82,000",
                "12,999",
                "white"
        );
        vehicleRepository.save(vehicle6);

        Vehicle vehicle7 = generateVehicle(
                "7777777777777",
                "bmwBlue",
                "BMW",
                "X3",
                "2021",
                "sDrive30i",
                "2,000",
                "45,999",
                "blue"
        );
        vehicleRepository.save(vehicle7);

        Vehicle vehicle8 = generateVehicle(
            "8888888888888",
                "hondaCivic",
                "Honda",
                "Civic",
                "2023",
                "Sedan LX",
                "1000",
                "25,045",
                "red"
        );
        vehicleRepository.save(vehicle8);

        System.out.println("Data Loaded = " + vehicleRepository.count());
    }

    public Vehicle generateVehicle(String vin, String imgName, String make, String model, String year, String type, String mileage, String price, String color) {
        Vehicle vehicle = new Vehicle();

        vehicle.setVin(vin);
        vehicle.setImgName(imgName);
        vehicle.setMake(make);
        vehicle.setModel(model);
        vehicle.setYear(year);
        vehicle.setType(type);
        vehicle.setMileage(mileage);
        vehicle.setPrice(price);
        vehicle.setColor(color);

        return vehicle;
    }
}
