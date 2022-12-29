package com.example.car_spring_boot.EntityConfigCar;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static jakarta.persistence.GenerationType.SEQUENCE;


@Entity(name = "Car")
@Table(name = "car")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarEntity {

    @Id
    @SequenceGenerator(
            name = "car_sequence",
            sequenceName = "car_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "car_sequence"
    )
    private Integer id;
    @Column(name = "MAKER")
    private String maker;
    @Column(name = "MODEL")
    private String model;
    @Column(name = "YEAR")
    private Integer year;


}
