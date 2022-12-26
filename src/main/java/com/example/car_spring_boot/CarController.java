package com.example.car_spring_boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/car")
public class CarController {

    private final CarService carService;
    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }



    @GetMapping
    public List<Car> carList() {
        return carService.carList();
    }

    @GetMapping("/{id}")
    public Optional<Car> getCarById(@PathVariable int id) {
        return carService.getCarById(id);
    }

    @PostMapping
    public Car addCar(@RequestBody Car car) {
        return carService.addCar(car);
    }

    @DeleteMapping("/{id}")
    public Void deleteCarById(@PathVariable int id) {
        return carService.deleteCarById(id);
    }

    @PutMapping("/{id}")
    public Car updateCarById(@PathVariable int id, @RequestBody Car car)  {
        return carService.updateCarById(id,car);
    }

}
