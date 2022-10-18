package com.crud.crud_01.repositories;

import com.crud.crud_01.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
