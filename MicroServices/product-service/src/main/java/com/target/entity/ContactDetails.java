package com.target.entity;

import lombok.Data;

@Data
public class ContactDetails {
    private String address;
    private String city;
    private String region;
    private String postalCode;
    private String country;
}