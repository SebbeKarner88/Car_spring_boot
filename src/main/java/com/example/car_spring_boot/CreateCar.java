package com.example.car_spring_boot;

import jakarta.persistence.Column;
import lombok.Value;

@Value
public class CreateCar {

    Integer id;

    String maker;

    String model;

    Integer year;

}
