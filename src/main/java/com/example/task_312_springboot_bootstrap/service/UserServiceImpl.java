package com.example.task_312_springboot_bootstrap.service;

import com.example.task_312_springboot_bootstrap.entity.Role;
import com.example.task_312_springboot_bootstrap.entity.User;
import com.example.task_312_springboot_bootstrap.repository.RoleDao;
import com.example.task_312_springboot_bootstrap.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service

public class UserServiceImpl implements UserService{
    private final UserDao userDao;

    @Autowired
    private RoleDao roleDao;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    @Transactional
    public User findeById(long id) {
        Optional <User> optionalUser = userDao.findById(id);
        return optionalUser.get();
    }

    @Override
    @Transactional
    public void save(User user) {
        userDao.save(user);

    }

    @Override
    @Transactional
    public void delete(User user) {
        userDao.delete(user);

    }

    @Override
    public User findUserByEmail(String email) {
        return userDao.findUserByEmail(email);
    }


    @Override
    @Transactional
    public Role getRoleByName(String name) {
        return roleDao.getRoleByName(name);
    }
}
