package com.target.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@Embeddable
public class ContactDetails {
    private String address;
    private String city;
    private String region;
    @Column(name="postal_code")
    private String postalCode;
    private String country;
}