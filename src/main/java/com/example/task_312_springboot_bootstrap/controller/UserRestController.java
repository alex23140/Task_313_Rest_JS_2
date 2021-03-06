package com.example.task_312_springboot_bootstrap.controller;

import com.example.task_312_springboot_bootstrap.entity.User;
import com.example.task_312_springboot_bootstrap.service.RoleServiceImpl;
import com.example.task_312_springboot_bootstrap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api")
public class UserRestController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleServiceImpl roleService;

    @GetMapping("/getUser")
    public ResponseEntity<User> getUser() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findUserByEmail(name);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }


    @GetMapping("/getUsers")
    public List<User> listUsers() {
        return userService.findAll();
    }

    @GetMapping("/getUserById/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        try {
            User user = userService.findById(id);
            return new ResponseEntity<User>(user, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create")
    public void create(@RequestBody User user) {
        userService.save(user);
    }


    @PutMapping("/edit")
    public ResponseEntity<User> edit(@RequestBody User user) {
        try {
            userService.save(user);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(userService.findById(id));
    }
}