package com.boots.controller;

import com.boots.repository.AdminRepository;
import com.boots.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {
    @Autowired
    private UserService userService;


    @Autowired
    private AdminRepository adminRepository;


    @GetMapping("/init")
    public String init(Model model) {
        System.out.println("adminRepository-init---005");
        try {
            adminRepository.createUserRole();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            adminRepository.createStatus();
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            userService.createAdmin();
        } catch (Exception e) {
            e.printStackTrace();
        }


        model.addAttribute("allUsers", userService.allUsers());
        return "redirect:/";
    }


    @GetMapping("/admin")
    public String userList(Model model) {
        model.addAttribute("allUsers", userService.allUsers());
        return "admin";
    }


    @PostMapping("/admin")
    public String deleteUser(@RequestParam(required = true, defaultValue = "") Long userId,
                             @RequestParam(required = true, defaultValue = "") String action,
                             Model model) {
        if (action.equals("delete")) {
            userService.deleteUser(userId);
        }
        return "redirect:/admin";
    }

    @GetMapping("/admin/gt/{userId}")
    public String gtUser(@PathVariable("userId") Long userId, Model model) {
        model.addAttribute("allUsers", userService.usergtList(userId));
        return "admin";
    }
}
