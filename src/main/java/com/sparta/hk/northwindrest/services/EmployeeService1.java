package com.sparta.hk.northwindrest.services;

import com.sparta.hk.northwindrest.controllers.Employee.EmployeeWithName;
import com.sparta.hk.northwindrest.dtos.EmployeeDTO1;
import com.sparta.hk.northwindrest.entities.EmployeeEntities;
import com.sparta.hk.northwindrest.repositories.EmployeeRepository;
import com.sparta.hk.northwindrest.repositories.SupplierRepository;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService1{

    @Autowired
    private EmployeeRepository employeeRepository;

    public void setRepo(EmployeeRepository supplierRepository){
        this.employeeRepository= supplierRepository;
    }

    public List<EmployeeDTO1> getEmployeeWithName(Specification<EmployeeEntities>spec){
        return employeeRepository
                .findAll(spec)
                .stream()
                .map(this::convertToEmpDTO)
                .collect(Collectors.toList());
    }

    private EmployeeDTO1 convertToEmpDTO(EmployeeEntities employeeEntities){
        EmployeeDTO1 employeeDTO1 = new EmployeeDTO1();
        employeeDTO1.setEmployeeID(employeeEntities.getId());
        employeeDTO1.setFirstName(employeeEntities.getFirstName());
        employeeDTO1.setLastName(employeeEntities.getLastName());
        employeeDTO1.setTitle(employeeEntities.getTitle());
        employeeDTO1.setHomePhone(employeeEntities.getHomePhone());
        employeeDTO1.setTitleOfCourtesy(employeeEntities.getTitleOfCourtesy());

        return employeeDTO1;
    }
}
