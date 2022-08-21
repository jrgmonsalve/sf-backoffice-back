package com.softcaribbean.demo.models;

import javax.persistence.*;

@Entity
@Table(name = "customers")
public class CustomerModel {

    public static enum IdentificationTypes {
        CC,
        CE,
        NIT,
        PASSPORT
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private String name;

    @Enumerated(value = EnumType.STRING)
    private IdentificationTypes identificationType;

    private String identificationNumber;

    private String city;

    private String address;

    private String phone;

    private String observation;

    public CustomerModel() {
    }

    public CustomerModel(String name, IdentificationTypes identificationType, String identificationNumber, String city,
            String address, String phone, String observation) {
        this.name = name;
        this.identificationType = identificationType;
        this.identificationNumber = identificationNumber;
        this.city = city;
        this.address = address;
        this.phone = phone;
        this.observation = observation;
    }    

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setIdentificationType(IdentificationTypes identificationType) {
        this.identificationType = identificationType;
    }

    public IdentificationTypes getIdentificationType() {
        return this.identificationType;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public String toString() {
        return "ID:" + this.id + " NAME:" + this.name + " IDENTIFICATION_TYPE:" + this.identificationType
                + " IDENTIFICATION_NUMBER" + this.identificationNumber
                + " CITY:" + this.city + " ADDRESS:" + this.address + " PHONE:" + this.phone
                + " OBSERVATION:" + this.observation;
    }
}