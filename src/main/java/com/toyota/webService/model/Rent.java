package com.toyota.webService.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Rent {
    private int rentID;
    private int userID;
    private int itemID;
    private Date rentDate;
    private Date returnDate;

    public Rent(@JsonProperty("rentID")int rentID,
                @JsonProperty("userID")int userID,
                @JsonProperty("itemID")int itemID,
                @JsonProperty("rentDate")Date rentDate,
                @JsonProperty("returnDate")Date returnDate) {

        this.rentID = rentID;
        this.userID = userID;
        this.itemID = itemID;
        this.rentDate = rentDate;
        this.returnDate = returnDate;
    }

    public int getRentID() {
        return rentID;
    }

    public void setRentID(int rentID) {
        this.rentID = rentID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public Date getRentDate() {
        return rentDate;
    }

    public void setRentDate(Date rentDate) {
        this.rentDate = rentDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
}
