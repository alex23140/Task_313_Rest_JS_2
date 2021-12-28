package com.example.task_312_springboot_bootstrap.service;

import com.example.task_312_springboot_bootstrap.entity.Role;
import com.example.task_312_springboot_bootstrap.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(long id);
    void save(User user);
    void delete(User user);
    User findUserByEmail(String email);
    Role getRoleByName(String name);
}
