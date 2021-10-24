package com.sparta.hk.northwindrest.services;

import com.sparta.hk.northwindrest.controllers.Employee.EmployeeWithName;
import com.sparta.hk.northwindrest.dtos.EmployeeDTO1;
import com.sparta.hk.northwindrest.dtos.EmployeeDTO2;
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
public class EmployeeService2{

    @Autowired
    private EmployeeRepository employeeRepository;

    public void setRepo(EmployeeRepository supplierRepository){
        this.employeeRepository= supplierRepository;
    }

    public List<EmployeeDTO2> getEmployeeWithCityCountry(Specification<EmployeeEntities>spec2){
        return employeeRepository
                .findAll(spec2)
                .stream()
                .map(this::convertToEmpDTO)
                .collect(Collectors.toList());
    }

    private EmployeeDTO2 convertToEmpDTO(EmployeeEntities employeeEntities){
        EmployeeDTO2 employeeDTO2 = new EmployeeDTO2();
        employeeDTO2.setEmployeeID(employeeEntities.getId());
        employeeDTO2.setFirstName(employeeEntities.getFirstName());
        employeeDTO2.setLastName(employeeEntities.getLastName());
        employeeDTO2.setTitle(employeeEntities.getTitle());
        employeeDTO2.setHomePhone(employeeEntities.getHomePhone());
        employeeDTO2.setTitleOfCourtesy(employeeEntities.getTitleOfCourtesy());
        employeeDTO2.setSalary(employeeEntities.getSalary());
        employeeDTO2.setCountry(employeeEntities.getCountry());
        employeeDTO2.setPostalCode(employeeEntities.getPostalCode());
        employeeDTO2.setCity(employeeEntities.getCity());

        return employeeDTO2;
    }
}
