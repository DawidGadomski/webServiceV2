package com.toyota.webService.api;

import com.toyota.webService.model.User;
import com.toyota.webService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/user/scan")
    public User scanUser(@RequestBody User user){
        return userService.scanUser(user.getUserCode()).orElse(null);
    }

    @PostMapping("/users/add")
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }

    @DeleteMapping("/users/delete")
    public void deleteUser(@RequestBody User user){
        userService.deleteUser(user.getUserCode());
    }
}
