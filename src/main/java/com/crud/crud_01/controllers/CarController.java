package com.crud.crud_01.controllers;

import com.crud.crud_01.entities.Car;
import com.crud.crud_01.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    CarRepository carRepository;

    @PostMapping(value = "/create")
    public Car createCar(@RequestBody Car car) {
        return carRepository.save(car);
    }

    @GetMapping(value = "")
    public List<Car> getCar() {
        return carRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Car getOneCar(@PathVariable Long id) {
        Car car = new Car();
        if (carRepository.existsById(id)) {
            car = carRepository.findById(id).get();
        }
        return car;
    }

    @PutMapping("/{id}")
    public Car updateCar(@PathVariable Long id, @RequestParam String type) {
        Optional<Car> findCar = carRepository.findById(id);
        Car car = new Car();
        if (findCar.isPresent()) {
            car = findCar.get();
            car.setType(type);
            carRepository.save(car);
        }
        return car;
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteCar(@PathVariable Long id) {
        if (carRepository.existsById(id)) {
            carRepository.deleteById(id);
            return HttpStatus.ACCEPTED;
        } else {
            return HttpStatus.NO_CONTENT;
        }
    }

}
