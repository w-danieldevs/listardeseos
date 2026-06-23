package com.example.demo.dto.ListaItems;

import lombok.Data;

@Data
public class ListaItemsDTO {

    private long id;

    private Long listaId;

    private long nombre;

    private String nombreProducto;

    private Double precio;

    private double stock;

    private double cantidad;
}
