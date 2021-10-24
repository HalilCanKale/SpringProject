package com.sparta.hk.northwindrest.controllers.Employee;

import com.sparta.hk.northwindrest.entities.EmployeeEntities;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class EmployeeWithCityCountry implements Specification<EmployeeEntities> {
    private String country;
    private String city;

    public EmployeeWithCityCountry(String country, String city)  {
        this.country = country;
        this.city = city;
    }

    @Override
    public Predicate toPredicate(Root<EmployeeEntities> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        if(city==null && country==null){
            return cb.isTrue(cb.literal(true));
        }
        if(city==null){
            return cb.equal(root.get("country"), this.country);
        }
        if(country==null) {
            return cb.equal(root.get("city"), this.city);
        }
        return cb.and(cb.equal(root.get("city"),this.city), cb.equal(root.get("country"),this.country));
    }

}
