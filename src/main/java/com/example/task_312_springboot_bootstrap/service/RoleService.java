package com.example.task_312_springboot_bootstrap.service;

import com.example.task_312_springboot_bootstrap.entity.Role;

import java.util.List;

public interface RoleService {

    List<Role> getAllRoles();

    Role getRoleByName(String name);
}
