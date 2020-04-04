package com.toyota.webService.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//@Entity
public class Item {
//    @Id
//    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String name;
    private String code;
    private int rent;

    public Item() {
    }

    public Item(@JsonProperty("id") int id,
                @JsonProperty("name") String name,
                @JsonProperty("itemCode") String code,
                @JsonProperty("rent") int rent) {

        this.id = id;
        this.name = name;
        this.code = code;
        this.rent = rent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

}

