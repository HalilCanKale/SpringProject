package com.sparta.hk.northwindrest.repositories;

import com.sparta.hk.northwindrest.entities.CategoryEntities;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntities, Integer> {
}