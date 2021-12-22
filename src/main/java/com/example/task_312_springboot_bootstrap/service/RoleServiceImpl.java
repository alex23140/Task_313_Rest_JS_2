package com.example.task_312_springboot_bootstrap.service;

import com.example.task_312_springboot_bootstrap.entity.Role;
import com.example.task_312_springboot_bootstrap.repository.RoleDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Transactional
    public List<Role> getAllRoles() {
        return roleDao.findAll();
    }

    @Transactional
    public Role getRoleByName(String name) {
        return roleDao.getRoleByName(name);
    }
}
