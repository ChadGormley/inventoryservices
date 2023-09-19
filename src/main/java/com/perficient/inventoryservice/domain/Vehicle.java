package com.perficient.inventoryservice.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
}
