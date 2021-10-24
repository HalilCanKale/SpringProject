package com.sparta.hk.northwindrest.controllers.Shipper;

import com.sparta.hk.northwindrest.entities.ShipperEntities;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

class ShipperWithCompanyName implements Specification<ShipperEntities> {

    private String companyName;

    public ShipperWithCompanyName(String companyName) {
        this.companyName=companyName;
    }

    @Override
    public Predicate toPredicate(Root<ShipperEntities> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
       if(companyName==null){
           return cb.isTrue(cb.literal(true));
       }
       return cb.equal(root.get("companyName"), this.companyName);
    }
}
