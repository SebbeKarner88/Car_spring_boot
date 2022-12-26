package com.example.car_spring_boot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CarConfig {

    @Bean
    CommandLineRunner commandLineRunner (CarRepository carRepository) {
        return args -> {

            Car car1 = new Car(
                    1,
                    "Ford",
                    "Escape",
                    1992
            );
            Car car2 = new Car(
                    2,
                    "Lamborghini",
                    "Countach",
                    1988
            );
            Car car3 = new Car(
                    3,
                    "Volvo",
                    "V90",
                    2022
            );
            carRepository.saveAll(List.of(car1, car2, car3));
        };
    }
}
