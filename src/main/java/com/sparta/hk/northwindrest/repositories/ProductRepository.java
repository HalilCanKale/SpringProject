package com.sparta.hk.northwindrest.repositories;

import com.sparta.hk.northwindrest.entities.ProductEntities;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntities, Integer> {
}