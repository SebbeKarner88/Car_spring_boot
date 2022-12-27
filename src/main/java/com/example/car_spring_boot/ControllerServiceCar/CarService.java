package com.example.car_spring_boot.ControllerServiceCar;

import com.example.car_spring_boot.EntityConfigCar.CarEntity;
import com.example.car_spring_boot.CarRepository.CarRepository;
import com.example.car_spring_boot.CreateUpdateCar.CreateCar;
import com.example.car_spring_boot.CreateUpdateCar.UpdateCar;
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
    public CarEntity createCar(CreateCar createCar) {

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
    public CarEntity updateCarById(int id, UpdateCar updateCar) {

        CarEntity newCar = new CarEntity();

        Optional<CarEntity> oldCar = carRepository.findById(id);

        if (oldCar.isPresent()) {
        newCar = oldCar.get();

            if (updateCar.getMaker() != null && !updateCar.getMaker().equals(newCar.getMaker())){
                newCar.setMaker(updateCar.getMaker());
            }
            if (updateCar.getModel() != null && !updateCar.getModel().equals(newCar.getModel())){
                newCar.setModel(updateCar.getModel());
            }
            if (updateCar.getYear() != null && !updateCar.getYear().equals(newCar.getYear())){
                newCar.setYear(updateCar.getYear());
            }
        }
        carRepository.save(newCar);
        return newCar;
    }
}
