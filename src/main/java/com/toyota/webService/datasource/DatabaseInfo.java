package com.toyota.webService.datasource;

import org.springframework.stereotype.Component;

@Component
public class DatabaseInfo {
    //  User columns
    private String usersDatabase;
    private String userColumn1;
    private String userColumn2;
    private String userColumn3;
    private String userColumn4;
    private String userColumn5;
    private String userColumn6;
    //  Item columns
    private String itemsDatabase;
    private String itemColumn1;
    private String itemColumn2;
    private String itemColumn3;
    private String itemColumn4;
    //  Rent columns
    private String rentsDatabase;
    private String rentColumn1;
    private String rentColumn2;
    private String rentColumn3;
    private String rentColumn4;
    private String rentColumn5;

    public DatabaseInfo(){
//      User columns
        usersDatabase = "Uzytkownik";
        userColumn1 = "ID_Uzytkownik";
        userColumn2 = "Imie";
        userColumn3 = "Nazwisko";
        userColumn4 = "Kod_karty";
//        userColumn5 = "login";
//        userColumn6 = "password";

//      Item columns
        itemsDatabase = "Urzadzenie";
        itemColumn1 = "ID_Urzadzenie";
        itemColumn2 = "Nazwa";
        itemColumn3 = "Kod_urzadzenia";
        itemColumn4 = "Wypozyczone";

//      Rent columns
        rentsDatabase = "Wypozyczenie";
        rentColumn1 = "ID_Wypozyczenie";
        rentColumn2 = "ID_Uzytkownik";
        rentColumn3 = "ID_Urzadzenie";
        rentColumn4 = "Data_wypozyczenia";
        rentColumn5 = "Data_zwrotu";
    }

    public String getUserColumn1() {
        return userColumn1;
    }

    public String getUserColumn2() {
        return userColumn2;
    }

    public String getUserColumn3() {
        return userColumn3;
    }

    public String getUserColumn4() {
        return userColumn4;
    }

    public String getUserColumn5() {
        return userColumn5;
    }

    public String getUserColumn6() {
        return userColumn6;
    }

    public String getItemColumn1() {
        return itemColumn1;
    }

    public String getItemColumn2() {
        return itemColumn2;
    }

    public String getItemColumn3() {
        return itemColumn3;
    }

    public String getItemColumn4() {
        return itemColumn4;
    }

    public String getRentColumn1() {
        return rentColumn1;
    }

    public String getRentColumn2() {
        return rentColumn2;
    }

    public String getRentColumn3() {
        return rentColumn3;
    }

    public String getRentColumn4() {
        return rentColumn4;
    }

    public String getRentColumn5() {
        return rentColumn5;
    }

    public String getUsersDatabase() {
        return usersDatabase;
    }

    public String getItemsDatabase() {
        return itemsDatabase;
    }

    public String getRentsDatabase() {
        return rentsDatabase;
    }
}
