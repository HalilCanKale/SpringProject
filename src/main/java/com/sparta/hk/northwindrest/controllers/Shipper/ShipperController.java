package com.sparta.hk.northwindrest.controllers.Shipper;

import com.sparta.hk.northwindrest.entities.ShipperEntities;
import com.sparta.hk.northwindrest.repositories.ShipperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shippers")
public class ShipperController {


    private final ShipperRepository shipperRepository;

    @Autowired
    public ShipperController(ShipperRepository shipperRepository) {
        this.shipperRepository = shipperRepository;
    }


    @GetMapping
    public List<ShipperEntities> getShippers(@RequestParam(value = "companyName", required = false) String companyName){
        if(companyName==null) {
            return shipperRepository.findAll();
        }
        Specification<ShipperEntities> spec = Specification.where(new ShipperWithCompanyName(companyName));
        return shipperRepository.findAll(spec);
    }


//    @GetMapping("/products/{id}")
//    public Optional<ProductEntities> getProductsById(@PathVariable Integer id) {
//        return productRepository.findById(id);
//    }
//}
}
