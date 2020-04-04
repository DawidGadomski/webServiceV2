package com.toyota.webService.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String userCode;

    public User(@JsonProperty("id") int id,
                @JsonProperty("firstName")String firstName,
                @JsonProperty("lastName")String lastName,
                @JsonProperty("userCode")String userCode) {

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userCode = userCode;


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }
}
