package com.example.demo.repository;

import com.example.demo.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> findByDoors(Integer doors);

    List<Car> findByManufacturerAndModel(String manufacturer, String model);

    List<Car> findByDoorsGreaterThanEqual(Integer doors);

    List<Car> findByModelContaining(String model);

    List<Car> findByYearIn(List<Integer> years); //buscar todos los Car de una determinada lista de años

    List<Car> findByYearBetween(Integer startYear, Integer endYear); //dame todos los coches del año 2000 al 2010

    List<Car> findByReleaseDateBetween(LocalDate startDate, LocalDate endDate); //todos los coches con rango de fecha día y mes

    List<Car> findByAvailableTrue();

    Long deleteAllByAvailableFalse();




}
