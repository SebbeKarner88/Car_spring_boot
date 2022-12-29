package com.example.car_spring_boot.DTOPackage;

import lombok.Value;

@Value
public class CarRequestDTO {

    Integer id;

    String maker;

    String model;

    Integer year;
}
