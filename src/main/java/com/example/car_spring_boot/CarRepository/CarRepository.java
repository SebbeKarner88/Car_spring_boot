package com.example.car_spring_boot.CarRepository;

import com.example.car_spring_boot.EntityConfigCar.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository <CarEntity, Integer>{

    /** Här kan vi lägga in kommandon för att skapa specifika sökfunktioner. **/


}
