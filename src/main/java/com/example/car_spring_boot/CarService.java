package com.example.car_spring_boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    private final CarRepository carRepository;
    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }



    @GetMapping
    public List<Car> carList() {
        return carRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Car> getCarById(@PathVariable Integer id) {
        return carRepository.findById(id);
    }

    @PostMapping
    public Car addCar(@RequestBody Car car) {
        carRepository.save(car);
        return car;
    }

    @DeleteMapping("/{id}")
    public Void deleteCarById(@PathVariable Integer id) {
        carRepository.deleteById(id);
        return null;
    }

    @PutMapping("/{id}")
    public Car updateCarById(@PathVariable int id, @RequestBody Car car)  {
        car.setId(id);
        carRepository.save(car);
        return car;
    }

}
