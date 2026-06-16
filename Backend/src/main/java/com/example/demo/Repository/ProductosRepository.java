package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.*;
import java.util.Optional;


public interface ProductosRepository extends JpaRepository<ProductosEntity, Long> {
    Optional<ProductosEntity> findByNombre(String nombre);


    
}
