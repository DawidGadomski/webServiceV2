package com.toyota.webService.dao;

import com.toyota.webService.datasource.DatabaseInfo;
import com.toyota.webService.model.Rent;
import com.toyota.webService.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Repository("rents")
public class RentDao {

    private final JdbcTemplate jdbcTemplate;
    private final DatabaseInfo databaseInfo;


    @Autowired
    public RentDao(JdbcTemplate jdbcTemplate, DatabaseInfo databaseInfo) {
        this.jdbcTemplate = jdbcTemplate;
        this.databaseInfo = databaseInfo;
    }

    public List<Rent> getRents(){

        String query = String.format("SELECT * FROM %s", databaseInfo.getRentsDatabase());
        List<Rent> rents = jdbcTemplate.query(query, (resultSet, i) -> {
            int rentID = Integer.parseInt(resultSet.getString(databaseInfo.getRentColumn1()));
            int userID = Integer.parseInt(resultSet.getString(databaseInfo.getRentColumn2()));
            int itemID = Integer.parseInt(resultSet.getString(databaseInfo.getRentColumn3()));
            Date rentDate = Date.valueOf(resultSet.getString(databaseInfo.getRentColumn4()));
            Date returnDate = Date.valueOf(resultSet.getString(databaseInfo.getRentColumn5()));
            return new Rent(rentID, userID, itemID, rentDate, returnDate);
        });
        return rents;
    }

    public int rentItem(Rent rent){
        String query = String.format("INSERT INTO %s(%s, %s, %s, %s)"
                        + "VALUES(?, ?, ?, ?);",
                databaseInfo.getRentsDatabase(), databaseInfo.getRentColumn2(),
                databaseInfo.getRentColumn3(), databaseInfo.getRentColumn4(), databaseInfo.getRentColumn5()
                );
        jdbcTemplate.update(query, rent.getUserID(), rent.getItemID(), LocalDateTime.now(), LocalDateTime.now());
        return 1;
    }

    public int returnItem(int itemID){
        String query = String.format("DELETE FROM %s WHERE ID_Urzadzenie = ?", databaseInfo.getRentsDatabase());

        jdbcTemplate.update(query, itemID);
        return 1;
    }
}
