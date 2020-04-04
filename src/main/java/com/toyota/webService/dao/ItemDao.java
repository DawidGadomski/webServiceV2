package com.toyota.webService.dao;

import com.toyota.webService.datasource.DatabaseInfo;
import com.toyota.webService.model.Item;
import com.toyota.webService.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("items")
public class ItemDao {

    private final JdbcTemplate jdbcTemplate;
    private final DatabaseInfo databaseInfo;

    @Autowired
    public ItemDao(JdbcTemplate jdbcTemplate, DatabaseInfo databaseInfo) {
        this.jdbcTemplate = jdbcTemplate;
        this.databaseInfo = databaseInfo;
    }

    public List<Item> getItems(){
        String query = String.format("SELECT * FROM %s", databaseInfo.getItemsDatabase());
        List<Item> items = jdbcTemplate.query(query, (resultSet, i) -> {
            int id = Integer.parseInt(resultSet.getString(databaseInfo.getItemColumn1()));
            String name = resultSet.getString(databaseInfo.getItemColumn2());
            String code = resultSet.getString(databaseInfo.getItemColumn3());
            int rent = Integer.parseInt(resultSet.getString(databaseInfo.getItemColumn4()));
            return new Item(id, name, code, rent);
        });
        return items;
    }

    public Optional<List<Item>> getItemsByType(String type, String data){
        String query = String.format("SELECT * FROM %s WHERE %s = ?", databaseInfo.getItemsDatabase(), type);
        List<Item> items = jdbcTemplate.query(query, new Object[]{data}, (resultSet, i) -> {
            int id = Integer.parseInt(resultSet.getString(databaseInfo.getItemColumn1()));
            String name = resultSet.getString(databaseInfo.getItemColumn2());
            String code = resultSet.getString(databaseInfo.getItemColumn3());
            int rent = Integer.parseInt(resultSet.getString(databaseInfo.getItemColumn4()));
            return new Item(id, name, code, rent);
        });
        return Optional.ofNullable(items);
    }

    public Optional<Item> scanItem(String itemCode){
        String query = String.format("SELECT * FROM %s WHERE Kod_urzadzenia = ?", databaseInfo.getItemsDatabase());
        Item item = jdbcTemplate.queryForObject(query, (resultSet, i) -> {
            int id = Integer.parseInt(resultSet.getString(databaseInfo.getItemColumn1()));
            String name = resultSet.getString(databaseInfo.getItemColumn2());
            String code = resultSet.getString(databaseInfo.getItemColumn3());
            int rent = Integer.parseInt(resultSet.getString(databaseInfo.getItemColumn4()));
            return new Item(id, name, code, rent);
        });
        return Optional.ofNullable(item);
    }

    public int addItem(Item item){

        String query = String.format("INSERT INTO %s(%s, %s, %s)"
                        + "VALUES(?, ?, ?);",
                databaseInfo.getItemsDatabase(), databaseInfo.getItemColumn2(),
                databaseInfo.getItemColumn3(), databaseInfo.getItemColumn4()
                );
        System.out.println(query);
        jdbcTemplate.update(query,item.getName(), item.getCode(), item.getRent());
        return 1;
    }

    public int deleteItem(String itemCode){
        String query = String.format("DELETE FROM %s WHERE Kod_urzadzenia = ?", databaseInfo.getItemsDatabase());
        jdbcTemplate.update(query, itemCode);
        return 1;
    }
}
