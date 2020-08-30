package com.target.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="SUPPLIERS")
public class Supplier {
    @Id
    @Column(name="supplier_id")
    private Integer supplierId;
    @Column(name="company_name")
    private String companyName;
    @Column(name="contact_name")
    private String contactName;
    @Column(name="contact_title")
    private String contactTitle;

    @Embedded
    private ContactDetails contactDetails;

    private String phone;
    private String fax;
    @Column(name="home_page")
    private String homePage;
}