package com.sparta.hk.northwindrest.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Table(name = "orders", indexes = {
        @Index(name = "ShippedDate", columnList = "ShippedDate"),
        @Index(name = "ShipPostalCode", columnList = "ShipPostalCode"),
        @Index(name = "OrderDate", columnList = "OrderDate")
})
@Entity
public class OrderEntities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OrderID", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "CustomerID")
    private CustomerEntities customerEntitiesID;

    @ManyToOne
    @JoinColumn(name = "EmployeeID")
    private EmployeeEntities employeeEntitiesID;

    @Column(name = "OrderDate")
    private Instant orderDate;

    @Column(name = "RequiredDate")
    private Instant requiredDate;

    @Column(name = "ShippedDate")
    private Instant shippedDate;

    @ManyToOne
    @JoinColumn(name = "ShipVia")
    private ShipperEntities shipVia;

    @Column(name = "Freight", precision = 10, scale = 4)
    private BigDecimal freight;

    @Column(name = "ShipName", length = 40)
    private String shipName;

    @Column(name = "ShipAddress", length = 60)
    private String shipAddress;

    @Column(name = "ShipCity", length = 15)
    private String shipCity;

    @Column(name = "ShipRegion", length = 15)
    private String shipRegion;

    @Column(name = "ShipPostalCode", length = 10)
    private String shipPostalCode;

    @Column(name = "ShipCountry", length = 15)
    private String shipCountry;

    public String getShipCountry() {
        return shipCountry;
    }

    public void setShipCountry(String shipCountry) {
        this.shipCountry = shipCountry;
    }

    public String getShipPostalCode() {
        return shipPostalCode;
    }

    public void setShipPostalCode(String shipPostalCode) {
        this.shipPostalCode = shipPostalCode;
    }

    public String getShipRegion() {
        return shipRegion;
    }

    public void setShipRegion(String shipRegion) {
        this.shipRegion = shipRegion;
    }

    public String getShipCity() {
        return shipCity;
    }

    public void setShipCity(String shipCity) {
        this.shipCity = shipCity;
    }

    public String getShipAddress() {
        return shipAddress;
    }

    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public BigDecimal getFreight() {
        return freight;
    }

    public void setFreight(BigDecimal freight) {
        this.freight = freight;
    }

    public ShipperEntities getShipVia() {
        return shipVia;
    }

    public void setShipVia(ShipperEntities shipVia) {
        this.shipVia = shipVia;
    }

    public Instant getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(Instant shippedDate) {
        this.shippedDate = shippedDate;
    }

    public Instant getRequiredDate() {
        return requiredDate;
    }

    public void setRequiredDate(Instant requiredDate) {
        this.requiredDate = requiredDate;
    }

    public Instant getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Instant orderDate) {
        this.orderDate = orderDate;
    }

    public EmployeeEntities getEmployeeID() {
        return employeeEntitiesID;
    }

    public void setEmployeeID(EmployeeEntities employeeEntitiesID) {
        this.employeeEntitiesID = employeeEntitiesID;
    }

    public CustomerEntities getCustomerID() {
        return customerEntitiesID;
    }

    public void setCustomerID(CustomerEntities customerEntitiesID) {
        this.customerEntitiesID = customerEntitiesID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}