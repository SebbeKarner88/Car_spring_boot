package com.example.car_spring_boot.ControllerServiceCar;

import com.example.car_spring_boot.EntityConfigCar.CarEntity;
import com.example.car_spring_boot.CreateUpdateCar.CreateCar;
import com.example.car_spring_boot.CreateUpdateCar.UpdateCar;
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



    @GetMapping("/list")
    public List<CarEntity> carList() {
        return carService.carList();
    }

    @GetMapping("/get/{id}")
    public Optional<CarEntity> getCarById(@PathVariable int id) {
        return carService.getCarById(id);
    }

    @PostMapping("/create")
    public CarEntity createCar(@RequestBody CreateCar createCar) {
        return carService.createCar(createCar);
    }

    @DeleteMapping("/delete/{id}")
    public Void deleteCarById(@PathVariable int id) {
        return carService.deleteCarById(id);
    }

    @PutMapping("/update/{id}")
    public CarEntity updateCarById(@PathVariable int id, @RequestBody UpdateCar updateCar)  {
        return carService.updateCarById(id, updateCar);
    }

}
