package com.example.car_spring_boot.EntityConfigCar;

import com.example.car_spring_boot.CarRepository.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CarConfig {

    @Bean
    CommandLineRunner commandLineRunner (CarRepository carRepository) {
        return args -> {

            CarEntity carEntity1 = new CarEntity(
                    1,
                    "Ford",
                    "Escape",
                    1992
            );
            CarEntity carEntity2 = new CarEntity(
                    2,
                    "Lamborghini",
                    "Countach",
                    1988
            );
            CarEntity carEntity3 = new CarEntity(
                    3,
                    "Volvo",
                    "V90",
                    2022
            );
            carRepository.saveAll(List.of(carEntity1, carEntity2, carEntity3));
        };
    }
}
