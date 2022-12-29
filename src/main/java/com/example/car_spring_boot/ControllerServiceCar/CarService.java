package com.example.car_spring_boot.ControllerServiceCar;

import com.example.car_spring_boot.DTOPackage.CarRequestDTO;
import com.example.car_spring_boot.EntityConfigCar.CarEntity;
import com.example.car_spring_boot.CarRepository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    /** ############## REPOSITORY CONNECTION ##################################### **/
    private final CarRepository carRepository;
    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }
    /** ############## REPOSITORY CONNECTION ##################################### **/

    /**############ GET STUDENT LIST WITH DTO ################################### **/
    public List<CarEntity> carList() {
        return carRepository.findAll();
    }
    /**############ GET STUDENT LIST WITH DTO ################################### **/

    public CarEntity getCarById(Integer id) {

        Optional<CarEntity> OpCar = carRepository.findById(id);

        if (OpCar.isEmpty()){
            throw new IllegalStateException("Id finns inte");
        }

        return OpCar.get();
    }

    public Void deleteCarById(Integer id) {
        Optional<CarEntity> OpCar = carRepository.findById(id);

        if (OpCar.isEmpty()){
            throw new IllegalStateException("Id finns inte");
        }

        carRepository.deleteById(id);
        return null;
    }


    /** ############ UPDATE CAR WITH DTO AND REQUEST/RESPONSE ################# **/
    public Optional<CarEntity> updateCarDTO(Integer id, CarRequestDTO carRequestDTO) {

        return carRepository.findById(id)
                .map(carEntity -> {
                    if (carRequestDTO.getMaker() != null)
                        carEntity.setMaker(carRequestDTO.getMaker());
                    if (carRequestDTO.getModel() != null)
                        carEntity.setModel(carRequestDTO.getModel());
                    if (carRequestDTO.getYear() != null)
                        carEntity.setYear(carRequestDTO.getYear());
                    carRepository.save(carEntity);
                    return carEntity;
                });

    }
    /** ############ UPDATE CAR WITH DTO AND REQUEST/RESPONSE ################# **/



    /**############ CREATE STUDENT WITH DTO ################################### **/
    public Optional<CarEntity> createCarDTO(CarRequestDTO carRequestDTO) {

        CarEntity car = new CarEntity(
                null,
                carRequestDTO.getMaker(),
                carRequestDTO.getModel(),
                carRequestDTO.getYear()
        );
        carRepository.save(car);
        return Optional.of(car);
    }
    /**############ CREATE STUDENT WITH DTO ################################### **/

}
