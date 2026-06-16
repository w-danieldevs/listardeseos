package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.Repository.ProductosRepository;
import com.example.demo.entity.ProductosEntity;
import com.example.demo.dto.MessageResponse;
import com.example.demo.dto.Producto.ProductoDTO;
import com.example.demo.dto.Producto.ProductoRequest;

import java.util.stream.Collectors;
import java.util.Optional;
import java.util.List;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductosService {

    private final ProductosRepository listaRepository;

    public MessageResponse createProducto(ProductoRequest request) {
        MessageResponse response = new MessageResponse();
        Optional<ProductosEntity> existingProduct = listaRepository.findByNombre(request.getNombre());

        if (existingProduct.isPresent()) {
            response.setMessage("El producto ya existe en la lista de deseos.");
            return response;
        }

        response.setMessage("Producto agregado a la lista de deseos.");
        ProductosEntity newProduct = new ProductosEntity();
        newProduct.setNombre(request.getNombre());
        newProduct.setPrecio(request.getPrecio());
        newProduct.setStock(request.getStock());
        newProduct.setCantidad(request.getCantidad());
        listaRepository.save(newProduct); 

        return response;
    }

    public List<ProductoDTO> getAllProducts() {
        List<ProductosEntity> products = listaRepository.findAll();
        return products.stream()
                .map(product -> {
                    ProductoDTO dto = new ProductoDTO();
                    dto.setId(product.getId());
                    dto.setNombre(product.getNombre());
                    dto.setPrecio(product.getPrecio());
                    dto.setStock(product.getStock());
                    dto.setCantidad(product.getCantidad());
                    return dto;
                })
                .collect(Collectors.toList());
       
    }

    public MessageResponse deleteProducto(Long id) {
        MessageResponse response = new MessageResponse();
        Optional<ProductosEntity> product = listaRepository.findById(id);

        if (product.isPresent()) {
            listaRepository.deleteById(id);
            response.setMessage("Producto eliminado de la lista de deseos.");
        } else {
            response.setMessage("Producto no encontrado en la lista de deseos.");
        }

        return response;
    }





    
}
