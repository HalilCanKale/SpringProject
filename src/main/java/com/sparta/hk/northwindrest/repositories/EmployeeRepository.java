package com.sparta.hk.northwindrest.repositories;

import com.sparta.hk.northwindrest.dtos.EmployeeDTO1;
import com.sparta.hk.northwindrest.entities.EmployeeEntities;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<EmployeeEntities, Integer>, JpaSpecificationExecutor<EmployeeEntities> {
}