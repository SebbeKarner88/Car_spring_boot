package com.example.car_spring_boot.CreateUpdateCar;

import jakarta.persistence.Column;
import lombok.Value;

@Value
public class CreateCar {

    Integer id;

    String maker;

    String model;

    Integer year;

}
