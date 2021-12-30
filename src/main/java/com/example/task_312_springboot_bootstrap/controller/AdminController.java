package com.example.task_312_springboot_bootstrap.controller;


import com.example.task_312_springboot_bootstrap.service.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/")
public class AdminController {



    @Autowired
    private RoleServiceImpl roleService;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }


    @GetMapping("/user")
    public String getUserPage(){
        return "showUser";
    }


    @GetMapping("/admin")
    public String getAdminPage(Model model) {
        model.addAttribute("allRoles", roleService.getAllRoles());
        return "admin";
    }

}

