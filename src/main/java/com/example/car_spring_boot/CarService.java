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



    @GetMapping("/list")
    public List<CarEntity> carList() {
        return carRepository.findAll();
    }

    @GetMapping("/get/{id}")
    public Optional<CarEntity> getCarById(@PathVariable Integer id) {
        return carRepository.findById(id);
    }

    @PostMapping("/create")
    public CarEntity createCar(@RequestBody CreateCar createCar) {

        CarEntity car = new CarEntity(
                createCar.getId(),
                createCar.getMaker(),
                createCar.getModel(),
                createCar.getYear()
        );
        carRepository.save(car);
        return car;
    }

    @DeleteMapping("/delete/{id}")
    public Void deleteCarById(@PathVariable Integer id) {
        carRepository.deleteById(id);
        return null;
    }

    @PutMapping("/update/{id}")
    public CarEntity updateCarById(@PathVariable int id, @RequestBody CarEntity carEntity)  {
        carEntity.setId(id);
        carRepository.save(carEntity);
        return carEntity;
    }

}
