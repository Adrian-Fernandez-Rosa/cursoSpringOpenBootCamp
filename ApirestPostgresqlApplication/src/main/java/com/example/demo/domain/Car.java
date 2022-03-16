package com.example.demo.domain;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("ID car autoincremental")
    private Long id;

    @Column(name = "fabricante")
    private String manufacturer;
    private String model;
    private Double cc;
    private Integer doors;

    private Integer year;
    private LocalDate releaseDate; // BETWEEN
    private Boolean available;

    public Car() {
    }

    public Car( String manufacturer, String model, Double cc, Integer doors, Integer year, LocalDate releaseDate, Boolean available) {

        this.manufacturer = manufacturer;
        this.model = model;
        this.cc = cc;
        this.doors = doors;
        this.year = year;
        this.releaseDate = releaseDate;
        this.available = available;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getCc() {
        return cc;
    }

    public void setCc(Double cc) {
        this.cc = cc;
    }

    public Integer getDoors() {
        return doors;
    }

    public void setDoors(Integer doors) {
        this.doors = doors;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}
