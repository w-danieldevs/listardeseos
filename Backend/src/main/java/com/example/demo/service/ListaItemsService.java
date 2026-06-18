package com.example.demo.service;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import com.example.demo.Repository.ListaItemsRepository;



@RequiredArgsConstructor
@Service
public class ListaItemsService {

    private final ListaItemsRepository listaItemsRepository;

     
}
