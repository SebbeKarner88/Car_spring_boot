package com.example.car_spring_boot.DTOPackage;

import lombok.Value;

@Value
public class CarResponseDTO {

    Integer id;

    String maker;

    String model;

    Integer year;

}
