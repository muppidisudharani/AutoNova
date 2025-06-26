package com.girlsteam.Car.Controller;

import com.girlsteam.Car.CarApplication;
import com.girlsteam.Car.Entity.Cars;
import com.girlsteam.Car.Repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.lang.String;

@RestController
@RequestMapping("/cars")
public class CarController {
    @Autowired
    private CarRepository carRepository;
    @GetMapping
    public List<Cars> getAllCars(){
        return carRepository.findAll();
    }
    @GetMapping("/{id}")
    public Optional<Cars> getCarById(@PathVariable("id") int id){
        return carRepository.findById(id);
    }
    @GetMapping("/color/{color}")
    public List<Cars> getCarByColor(@PathVariable("color") String color){
        return carRepository.findByColor(color);
    }
    @GetMapping("/price/{price}")
    public List<Cars> getCarByPrice(@PathVariable("price") double price){
        return carRepository.findByPrice(price);
    }
    @GetMapping("/model/{model}")
    public List<Cars> getCarByModel(@PathVariable("model") String model){
        return carRepository.findByModel(model);
    }
    @PostMapping("/cars")
    public String createNewCar(@RequestBody Cars newCar){
        carRepository.save(newCar);
        return "Created new car "+newCar.getName();
    }
    @PutMapping("/cars/{id}")
    public String updateCar(@PathVariable("id") int id,@RequestBody Cars updatedCar){
        Optional<Cars> existingCar=carRepository.findById(id);
        if(existingCar.isPresent()){
            updatedCar.setId(id);
            carRepository.save(updatedCar);
            return "Updated car with Id "+id;
        }
        return "Car with model "+id+" not found";
    }
    @PutMapping("/cars/{id}/price")
    public String updateCarPrice(@PathVariable("id")int id,@RequestBody double newPrice){
        Optional<Cars> existingCar=carRepository.findById(id);
        if(existingCar.isPresent()){
            Cars cars=existingCar.get();
            cars.setPrice(newPrice);
            carRepository.save(cars);
            return "Updated price car "+id;
        }
        return "Car id "+id+" not found";
    }
    @DeleteMapping("/cars/id/{id}")
    public String deleteCar(@PathVariable("id") int id){
        if (carRepository.existsById(id)){
            carRepository.deleteById(id);
            return "Car deleted successfully";
        }
        else{
            return "Car is not found";
        }
    }
    @DeleteMapping("/cars/name/{name}")
    public String deleteCar(@PathVariable("name") String name){
        List<Cars> cars=carRepository.findByName(name);
        if (!cars.isEmpty()){
            carRepository.deleteAll(cars);
            return "Car with name "+name+" deleted successfully";
        }
        else{
            return "car with name "+name+" not found";
        }
    }
}
