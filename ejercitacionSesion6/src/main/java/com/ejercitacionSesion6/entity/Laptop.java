package com.ejercitacionSesion6.entity;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marca;
    private String procesador;
    private Integer ram;
    private String SistemaOperativo;

    public Laptop(Long codigoBarra, String marca, String procesador, Integer ram, String sistemaOperativo) {
        this.id = codigoBarra;
        this.marca = marca;
        this.procesador = procesador;
        this.ram = ram;
        SistemaOperativo = sistemaOperativo;
    }

    public Laptop() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getProcesador() {
        return procesador;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }

    public Integer getRam() {
        return ram;
    }

    public void setRam(Integer ram) {
        this.ram = ram;
    }

    public String getSistemaOperativo() {
        return SistemaOperativo;
    }

    public void setSistemaOperativo(String sistemaOperativo) {
        SistemaOperativo = sistemaOperativo;
    }


}
