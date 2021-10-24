package com.sparta.hk.northwindrest.controllers.Product;

import com.sparta.hk.northwindrest.entities.ProductEntities;
import com.sparta.hk.northwindrest.repositories.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class ProductController {
    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/products")
    @ResponseBody
    public List<ProductEntities> getAllProducts() {
            return productRepository.findAll();
    }

    @GetMapping(value="/products",params={"productName"})
    public List<ProductEntities> getProductsByProductName(@RequestParam(value= "productName") String productName){
        return productRepository.findAll()
                .stream()
                .filter(productEntity -> productEntity.getProductName().contains(productName))
                .collect(Collectors.toList());
    }

    @GetMapping(value="/products",params={"productName","unitPrice"})
    public List<ProductEntities> getProductsByProductNameUnitPrice(@RequestParam(required = false) String productName, @RequestParam(required = false) int unitPrice){
        return productRepository.findAll()
                .stream()
                .filter(productEntity -> (productEntity.getProductName().contains(productName)
                        &&(productEntity.getUnitPrice().intValue()==unitPrice))).collect(Collectors.toList());
    }

    @GetMapping(value="/products/InStock")
    public List<ProductEntities> getProductsStock(){
        return productRepository.findAll()
                .stream()
                .filter(productEntity -> productEntity.getUnitsInStock() >0)
                .collect(Collectors.toList());
    }

//    @GetMapping(value="/products/OutOfStock")
//    public List<ProductEntities> getProductsStock(){
//        return productRepository.findAll()
//                .stream()
//                .filter(productEntity -> productEntity.getUnitsInStock() >0)
//                .collect(Collectors.toList());
//    }

    @GetMapping("/products/{id}")
    public Optional<ProductEntities> getProductsById(@PathVariable Integer id) {
        return productRepository.findById(id);
    }
}
