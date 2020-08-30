package com.target.entity;

import lombok.Data;

@Data
public class Supplier {
    private Integer supplierId;
    private String companyName;
    private String contactName;
    private String contactTitle;
    private ContactDetails contactDetails = new ContactDetails();
    private String phone;
    private String fax;
    private String homePage;
}