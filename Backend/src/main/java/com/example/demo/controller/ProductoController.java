package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.example.demo.service.ProductosService;
import org.springframework.http.ResponseEntity;
import com.example.demo.dto.MessageResponse;
import com.example.demo.dto.Producto.ProductoRequest;
import com.example.demo.dto.Producto.ProductoDTO;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/productos")
@RequiredArgsConstructor
public class ProductoController {

    private final ProductosService productosService;

    @PostMapping("/create")
    public ResponseEntity<MessageResponse> createProducto(@RequestBody ProductoRequest productoRequest) {
    try {
        MessageResponse response = productosService.createProducto(productoRequest);
        return ResponseEntity.ok(response);
    } catch (Exception e) {
        MessageResponse errorResponse = new MessageResponse();
        errorResponse.setMessage("Error al agregar el producto: " + e.getMessage());
        return ResponseEntity.status(500).body(errorResponse);
    }
    }


    @GetMapping("/get-productos")
    public List<ProductoDTO> getAllProducts() {
        return productosService.getAllProducts();
    }

    @DeleteMapping("/delete/{id}")
    public MessageResponse deleteProducto(@PathVariable Long id) {
        MessageResponse response = productosService.deleteProducto(id);
        return response;
    }
 
    
   
    
    


    
}
