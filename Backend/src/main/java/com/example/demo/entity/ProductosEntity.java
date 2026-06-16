package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "productos")
@Data
public class ProductosEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long id;

    private String nombre;
    private double precio;
    private double stock;
    private double cantidad;
    


    
}
