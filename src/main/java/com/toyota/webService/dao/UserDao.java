package com.toyota.webService.dao;

import com.toyota.webService.datasource.DatabaseInfo;
import com.toyota.webService.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

//@Qualifier("mssqlUser")
@Repository("users")
public class UserDao {

    private final JdbcTemplate jdbcTemplate;
    private final DatabaseInfo databaseInfo;

    @Autowired
    public UserDao(JdbcTemplate jdbcTemplate, DatabaseInfo databaseInfo) {
        this.jdbcTemplate = jdbcTemplate;
        this.databaseInfo = databaseInfo;
    }

    public List<User> getUsers(){
        String query = String.format("SELECT * FROM %s", databaseInfo.getUsersDatabase());
        List<User> users = jdbcTemplate.query(query, (resultSet, i) -> {
            int id = Integer.parseInt(resultSet.getString(databaseInfo.getUserColumn1()));
            String firstName = resultSet.getString(databaseInfo.getUserColumn2());
            String lastName = resultSet.getString(databaseInfo.getUserColumn3());
            String userCode = resultSet.getString(databaseInfo.getUserColumn4());
            return new User(id, firstName, lastName, userCode);
        });

        return users;
    }

    public Optional<List<User>> getUsers(String type, String data){
        String query = String.format("SELECT * FROM %s WHERE %s = ?", databaseInfo.getUsersDatabase(), type);
        List<User> users = jdbcTemplate.query(query, new Object[]{data}, (resultSet, i) -> {
            int id = Integer.parseInt(resultSet.getString(databaseInfo.getUserColumn1()));
            String firstName = resultSet.getString(databaseInfo.getUserColumn2());
            String lastName = resultSet.getString(databaseInfo.getUserColumn3());
            String userCode = resultSet.getString(databaseInfo.getUserColumn4());
            return new User(id, firstName, lastName, userCode);
        });
        return Optional.ofNullable(users);
    }

    public Optional<User> scanUser(String userCard){
        String query = String.format("SELECT * FROM %s WHERE Kod_karty = ?", databaseInfo.getUsersDatabase());
        User user = jdbcTemplate.queryForObject(query, new Object[]{userCard}, (resultSet, i) -> {
            int id = Integer.parseInt(resultSet.getString(databaseInfo.getUserColumn1()));
            String firstName = resultSet.getString(databaseInfo.getUserColumn2());
            String lastName = resultSet.getString(databaseInfo.getUserColumn3());
            String userCode = resultSet.getString(databaseInfo.getUserColumn4());
            return new User(id, firstName, lastName, userCode);
        });
        return Optional.ofNullable(user);
    }

    public int addUser(User user){
        String query = String.format("INSERT INTO %s(%s, %s, %s)"
                        + "VALUES(?, ?, ?);",
                databaseInfo.getUsersDatabase(), databaseInfo.getUserColumn2(),
                databaseInfo.getUserColumn3(), databaseInfo.getUserColumn4()
                );
        jdbcTemplate.update(query, user.getFirstName(), user.getLastName(), user.getUserCode());
        return 1;
    }

    public int deleteUser(String userCard){
        String query = String.format("DELETE FROM %s WHERE Kod_karty = ?", databaseInfo.getUsersDatabase());
        jdbcTemplate.update(query, userCard);
        return 1;
    }
}
