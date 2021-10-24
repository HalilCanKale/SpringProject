package com.sparta.hk.northwindrest.repositories;

import com.sparta.hk.northwindrest.entities.SupplierEntities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SupplierRepository extends JpaRepository<SupplierEntities, Integer>{
}