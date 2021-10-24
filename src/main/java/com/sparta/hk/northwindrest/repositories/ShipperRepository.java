package com.sparta.hk.northwindrest.repositories;

import com.sparta.hk.northwindrest.entities.ShipperEntities;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ShipperRepository extends JpaRepository<ShipperEntities, Integer>, JpaSpecificationExecutor<ShipperEntities>{}