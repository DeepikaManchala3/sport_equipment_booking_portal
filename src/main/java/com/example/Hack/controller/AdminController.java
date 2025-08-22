package com.example.Hack.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {

    @GetMapping("/")
    public String home() {
        return "home";  // loads home.html
    }

    @GetMapping("/adminlogin")
    public String showLoginForm() {
        return "adminlogin";  // loads adminlogin.html
    }

    @PostMapping("/adminlogin")
public String adminLogin(@RequestParam String username,
                         @RequestParam String password,
                         Model model) {
    if (username.equals("admin") && password.equals("admin123")) {
        // Redirect to dashboard on success
        return "redirect:/admin-dashboard.html";
    } else {
        // Show error on failure
        model.addAttribute("error", "Invalid credentials");
        return "redirect:/adminlogin.html";
    }
}
    @GetMapping("/admin-dashboard")
    public String dashboard() {
        return "redirect:/admin-dashboard";  // loads admindashboard.html
    }
}