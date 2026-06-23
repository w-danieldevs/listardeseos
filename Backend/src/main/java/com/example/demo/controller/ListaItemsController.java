package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.MessageResponse;
import com.example.demo.dto.ListaItems.ListaItemsRequest;
import com.example.demo.service.ListaItemsService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/lista-items")
@CrossOrigin(origins = "http://localhost:4200")
public class ListaItemsController {

    private final  ListaItemsService listaItemsService;

   
    
    @PostMapping
    public ResponseEntity<MessageResponse> agregarProducto(
            @RequestBody ListaItemsRequest request) {

        return ResponseEntity.ok(
                listaItemsService.agregarItem(request)
        );
    }
}
