package com.example.demo.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import com.example.demo.Repository.ListaItemsRepository;
import com.example.demo.Repository.ProductosRepository;
import com.example.demo.dto.MessageResponse;
import com.example.demo.dto.ListaItems.ListaItemsRequest;
import com.example.demo.entity.ListaitemsEntity;
import com.example.demo.entity.ProductosEntity;


@RequiredArgsConstructor
@Service
public class ListaItemsService {

    private final ListaItemsRepository listaItemsRepository;
    private final ProductosRepository productosRepository;

    public MessageResponse agregarItem(ListaItemsRequest request) {

        MessageResponse response = new MessageResponse();

        System.out.println("ID recibido: " + request.getProductoId());

        
        Optional<ProductosEntity> producto =
                productosRepository.findById(request.getProductoId());

        if (producto.isEmpty()) {
            response.setMessage("Producto no encontrado");
            return response;
        }

        if (producto.get().getStock() < request.getCantidad()) {
            response.setMessage("Stock insuficiente");
            return response;
        }

        ListaitemsEntity item = new ListaitemsEntity();

        item.setProducto(producto.get());
        item.setCantidad(request.getCantidad());

        listaItemsRepository.save(item);

        response.setMessage("Producto agregado a la lista de deseos");

        return response;
    }
}

