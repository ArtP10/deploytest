package com.testdeploy.demo.controller;

import com.testdeploy.demo.model.User;
import com.testdeploy.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="*")
public class Controller {

    @Autowired
    private UserService userService;

    @GetMapping("/hello")
    public String greet(){
      return "Hello World";
    };

    @PostMapping("/users")
    public ResponseEntity<User> registerUser(@RequestBody User newUser){
        return this.userService.saveUser(newUser);
    }
    @DeleteMapping("/users")
    public HttpStatus deleteUser(@RequestBody User user){
        return this.userService.deleteUser(user);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers(){
        return this.userService.listUsers();
    }
}
