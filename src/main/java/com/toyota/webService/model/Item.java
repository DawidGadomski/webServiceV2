package com.toyota.webService.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    @NotNull
    private String name;
    @NotNull
    private String code;

    @Column(columnDefinition = "integer default 0")
    private int rent;

    public Item() {
    }

    public Item(@JsonProperty("id") int id,
                @JsonProperty("name") String name,
                @JsonProperty("code") String code,
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

