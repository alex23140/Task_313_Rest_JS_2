package com.example.task_312_springboot_bootstrap.repository;

import com.example.task_312_springboot_bootstrap.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;



public interface RoleDao extends JpaRepository<Role, Long> {
    Role getRoleByName(String name);

}
