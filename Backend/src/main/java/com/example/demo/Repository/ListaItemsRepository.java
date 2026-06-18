package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.ListaitemsEntity;
import java.util.Optional;

public interface ListaItemsRepository extends JpaRepository<ListaitemsEntity, Long> {
         Optional<ListaitemsEntity> findByProductoId(Long productoId);
}
