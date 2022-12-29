package com.example.car_spring_boot.ControllerServiceCar;

import com.example.car_spring_boot.DTOPackage.CarRequestDTO;
import com.example.car_spring_boot.DTOPackage.CarResponseDTO;
import com.example.car_spring_boot.EntityConfigCar.CarEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/car")
public class CarController {

    /**############## CARSERVICE CONNECTION ##################################### **/
    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }
    /**############## CARSERVICE CONNECTION ##################################### **/



    /**############ GET CAR LIST WITH DTO ####################################### **/
    @GetMapping("/list")
    public List<CarResponseDTO> carList() {
        return carService.carList()
                .stream()
                .map(this::carEntityToCarResponseDTO)
                .collect(Collectors.toList());
    }
    /**############ GET CAR LIST WITH DTO ####################################### **/



    /**############ GET CAR BY ID WITH DTO ###################################### **/
    @GetMapping("/get/{id}")
    public CarResponseDTO getCarByIdDTO(@PathVariable int id) {
        return carEntityToCarResponseDTO(carService.getCarByIdDTO(id));
    }
    /**############ GET CAR BY ID WITH DTO ###################################### **/


    /**############ DELETE CAR BY ID  ########################################### **/
    @DeleteMapping("/delete/{id}")
    public Void deleteCarById(@PathVariable int id) {
         carService.deleteCarById(id);
        return null;
    }
    /**############ DELETE CAR BY ID  ########################################### **/


    /** ############ UPDATE CAR WITH DTO AND REQUEST/RESPONSE ################# **/
    @PutMapping(path = "/update/{id}")
    public CarResponseDTO updateCarDTO(@RequestBody CarRequestDTO carRequestDTO, @PathVariable("id") Integer id) {

        return carService.updateCarDTO(id, carRequestDTO)
                .map(this::carEntityToCarResponseDTO)
                .orElse(null);
    }
    /** ############ UPDATE CAR WITH DTO AND REQUEST/RESPONSE ################# **/


    /**############ CREATE STUDENT WITH DTO ################################### **/
    @PostMapping(path = "/create")
    public CarResponseDTO createCarDTO(@RequestBody CarRequestDTO carRequestDTO) {

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
