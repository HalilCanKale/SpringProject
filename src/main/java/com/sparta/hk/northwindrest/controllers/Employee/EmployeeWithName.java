package com.sparta.hk.northwindrest.controllers.Employee;

import com.sparta.hk.northwindrest.dtos.EmployeeDTO1;
import com.sparta.hk.northwindrest.entities.EmployeeEntities;
import com.sparta.hk.northwindrest.entities.ShipperEntities;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class EmployeeWithName implements Specification<EmployeeEntities> {

    private String firstName;
    private String lastName;

    public EmployeeWithName(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


    @Override
    public Predicate toPredicate(Root<EmployeeEntities> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        if(firstName==null && lastName==null){
            return cb.isTrue(cb.literal(true));
        }
        if(firstName==null){
            return cb.equal(root.get("lastName"), this.lastName);
        }
        if(lastName==null) {
            return cb.equal(root.get("firstName"), this.firstName);
        }
        return cb.and(cb.equal(root.get("firstName"),this.firstName), cb.equal(root.get("lastName"),this.lastName));
        }

}
