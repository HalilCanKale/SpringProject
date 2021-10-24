package com.sparta.hk.northwindrest.repositories;

import com.sparta.hk.northwindrest.entities.OrderEntities;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntities, Integer> {
}