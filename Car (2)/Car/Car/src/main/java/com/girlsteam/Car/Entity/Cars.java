package com.girlsteam.Car.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "cartable")
public class Cars {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "model")
    private String model;
    @Column(name = "price")
    private Double price;
    @Column(name = "color")
    private String color;

    public Cars() {
    }

    public Cars(int id, String name, String model, Double price, String color) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.price = price;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public Double getPrice() {
        return price;
    }

    public String getColor() {
        return color;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
