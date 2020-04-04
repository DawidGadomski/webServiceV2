package com.toyota.webService.service;

import com.toyota.webService.dao.UserDao;
import com.toyota.webService.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service()
public class UserService {

    private final UserDao userDao;

    @Autowired
    public UserService(@Qualifier("users") UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> getUsers(){
        return userDao.getUsers();
    }

    public Optional<List<User>> getUsers(String type, String data){
        return userDao.getUsers(type, data);
    }

    public Optional<User> scanUser(String userCard){
        return userDao.scanUser(userCard);
    }

    public int addUser(User user){
        return userDao.addUser(user);
    }

    public int deleteUser(String userCard){
        return userDao.deleteUser(userCard);
    }
}
