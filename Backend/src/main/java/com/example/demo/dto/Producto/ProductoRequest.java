package com.example.demo.dto.Producto;

import lombok.Data;

@Data
public class ProductoRequest {

    private String nombre;
    private double precio;
    private double stock;
    private double cantidad;
    
}
