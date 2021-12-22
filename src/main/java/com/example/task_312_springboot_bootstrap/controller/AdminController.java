package com.example.task_312_springboot_bootstrap.controller;


import com.example.task_312_springboot_bootstrap.entity.Role;
import com.example.task_312_springboot_bootstrap.entity.User;
import com.example.task_312_springboot_bootstrap.service.RoleServiceImpl;
import com.example.task_312_springboot_bootstrap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleServiceImpl roleService;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }


    @GetMapping("/admin")
    public String commonAdminPage(Model model, Authentication authentication) {
        model.addAttribute("users", userService.findAll());
        model.addAttribute("user", new User());
        model.addAttribute("allRoles", roleService.getAllRoles());
        String name = authentication.getName();
        model.addAttribute("userAuthenticated", userService.findUserByEmail(name));
        return "admin";
    }

    @PostMapping("/edit")
    public String commonPageEditAddPost(@ModelAttribute("editUser") User user,
                                        @RequestParam("role") String[] role) {
        user.setRoles(getAddRole(role));
        userService.save(user);
        return "redirect:/admin";
    }

    private Set<Role> getAddRole(String[] role) {
        Set<Role> roleSet = new HashSet<>();
        for (String oneRole : role)
            roleSet.add(roleService.getRoleByName(oneRole));

        return roleSet;
    }

    @RequestMapping("/delete")
    public String delete(@ModelAttribute("deleteUser") User user) {
        userService.delete(user);
        return "redirect:/admin";
    }

    @GetMapping("/user")
    public String commonUserPageGet(Model model, Authentication authentication) {
        model.addAttribute("userAuthenticated", userService.findUserByEmail(authentication.getName()));
        return "showUser";
    }
}

