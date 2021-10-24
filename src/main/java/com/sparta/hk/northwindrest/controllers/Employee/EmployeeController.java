package com.sparta.hk.northwindrest.controllers.Employee;

import com.sparta.hk.northwindrest.dtos.EmployeeDTO1;
import com.sparta.hk.northwindrest.dtos.EmployeeDTO2;
import com.sparta.hk.northwindrest.entities.EmployeeEntities;
import com.sparta.hk.northwindrest.repositories.EmployeeRepository;
import com.sparta.hk.northwindrest.services.EmployeeService1;
import com.sparta.hk.northwindrest.services.EmployeeService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;
    private final EmployeeService1 employeeService1;
    private final EmployeeService2 employeeService2;

    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
        employeeService1 = new EmployeeService1();
        employeeService1.setRepo(employeeRepository);
        employeeService2 = new EmployeeService2();
        employeeService2.setRepo(employeeRepository);
    }

    @GetMapping("")
    public List<EmployeeDTO1> getEmployeeWithName(@RequestParam(value = "firstName", required = false) String firstName,
                                                  @RequestParam(value = "lastName", required = false) String lastName) {
        Specification<EmployeeEntities> spec = Specification.where(new EmployeeWithName(firstName, lastName));
        return employeeService1.getEmployeeWithName(spec);
    }


    @GetMapping("/cc")
    public List<EmployeeDTO2> getEmployeeWithSalaryCountry(@RequestParam(value = "city", required = false) String city,
                                                  @RequestParam(value = "country", required = false) String country) {
        Specification<EmployeeEntities> spec2 = Specification.where(new EmployeeWithCityCountry(country,city));
        return employeeService2.getEmployeeWithCityCountry(spec2);
    }

    @GetMapping("/Salary")
    public List<EmployeeDTO2> getEmployeeWithSalaryGreaterThan(@RequestParam(value = "salary", required = false) double salary) {
        Specification<EmployeeEntities> spec3 = Specification.where(new EmployeeWithSalary(salary));
        return employeeService2.getEmployeeWithCityCountry(spec3);
    }
}