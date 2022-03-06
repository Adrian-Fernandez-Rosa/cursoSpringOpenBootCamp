package com.example.obrestdatajpa.entidades;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "books")
@ApiModel("Entidad libro prara representar un articulo")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("Clave ficticia autoincremental tipo Long")
    private Long id;
    private String title;
    private String author;
    private Integer pages;
    @ApiModelProperty("Precio en euros, con dos decimales utilizando . como separador ") //ejemplo
    private Double price;
    private LocalDate releaseDate;
    private Boolean online;

    public Book() {
    }

    public Book(Long id, String title, String author, Integer pages, Double price, LocalDate releaseDate, Boolean online) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.price = price;
        this.releaseDate = releaseDate;
        this.online = online;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Boolean getOnline() {
        return online;
    }

    public void setOnline(Boolean online) {
        this.online = online;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", pages=" + pages +
                ", price=" + price +
                ", releaseDate=" + releaseDate +
                ", online=" + online +
                '}';
    }
}
