package com.target.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "PRODUCTS")
public class Product {
    @Id
    @GeneratedValue(generator = "increment") // SELECT MAX(PRODUCT_ID) +1 FROM PRODUCTS;
    @Column(name = "product_id")
    private Integer productId;
    @Column(name = "product_name")
    private String productName;
    @Column(name="supplier_id")
    private Integer supplierId;
    @Column(name="category_id")
    private Integer categoryId;
    @Column(name = "quantity_per_unit")
    private String quantityPerUnit;
    @Column(name = "unit_price")
    private Double unitPrice;
    @Column(name = "units_in_stock")
    private Integer unitsInStock;
    @Column(name = "units_on_order")
    private Integer unitsOnOrder;
    @Column(name = "reorder_level")
    private Integer reorderLevel;
    private Boolean discontinued;
}