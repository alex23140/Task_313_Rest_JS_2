package com.example.task_312_springboot_bootstrap.repository;

import com.example.task_312_springboot_bootstrap.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User,Long> {

    User findUserByEmail(String Email);
}
