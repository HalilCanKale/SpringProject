package com.sparta.hk.northwindrest.repositories;

import com.sparta.hk.northwindrest.entities.CustomerEntities;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntities, String> {
}