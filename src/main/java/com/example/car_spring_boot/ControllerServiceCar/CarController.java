package com.example.car_spring_boot.ControllerServiceCar;

import com.example.car_spring_boot.DTOPackage.CarRequestDTO;
import com.example.car_spring_boot.DTOPackage.CarResponseDTO;
import com.example.car_spring_boot.EntityConfigCar.CarEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public CarEntity getCarById(@PathVariable int id) {
        return carService.getCarById(id);
    }


    @DeleteMapping("/delete/{id}")
    public Void deleteCarById(@PathVariable int id) {
        return carService.deleteCarById(id);
    }


    /** ############ UPDATE CAR WITH DTO AND REQUEST/RESPONSE ################# **/
    @PutMapping(path = "/update/DTO/{id}")
    public CarResponseDTO updateCarDTO(
            @RequestBody CarRequestDTO carRequestDTO,
            @PathVariable("id") Integer id) {

        return carService.updateCarDTO(id, carRequestDTO)
                .map(this::carEntityToCarResponseDTO)
                .orElse(null);
    }
    /** ############ UPDATE CAR WITH DTO AND REQUEST/RESPONSE ################# **/


    /**############ CREATE STUDENT WITH DTO ################################### **/
    @PostMapping(path = "/create/DTO")
    public CarResponseDTO createCarDTO(
            @RequestBody CarRequestDTO carRequestDTO) {

        return carService.createCarDTO(carRequestDTO)
                .map(this::carEntityToCarResponseDTO)
                .orElse(null);
    }
    /**############ CREATE STUDENT WITH DTO ################################### **/


    /** ############ CAR-ENTITY TO CAR-RESPONSE DTO CONVERTER ################# **/
    private CarResponseDTO carEntityToCarResponseDTO(CarEntity carEntity) {
        return new CarResponseDTO(
                carEntity.getId(),
                carEntity.getMaker(),
                carEntity.getModel(),
                carEntity.getYear());
    }
    /** ############ CARE-NTITY TO CAR-RESPONSE DTO CONVERTER ################# **/
}
