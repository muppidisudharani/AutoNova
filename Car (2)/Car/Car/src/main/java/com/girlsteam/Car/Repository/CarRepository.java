package com.girlsteam.Car.Repository;

import com.girlsteam.Car.Entity.Cars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Cars,Integer> {
    List<Cars> findByColor(String color);
    List<Cars> findByPrice(Double price);
    List<Cars> findByModel(String model);
    List<Cars> findByName(String name);
}
