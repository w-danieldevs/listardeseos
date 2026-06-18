package com.example.demo.dto.ListaItems;

import lombok.Data;

@Data
public class ListaItemsDTO {

    private long id;

    private long idProducto;

    private String nombreProducto;

    private Double precio;

    private double stock;

    private double cantidad;
}
