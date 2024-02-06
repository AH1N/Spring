package com.example.Security4.Security4.Controller;

import lombok.AllArgsConstructor;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.context.annotation.Role;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class SecurityController{

    @GetMapping("/user")
    public String userPage() {
        return "user-page";
    }

    @GetMapping("/Admin")
    public String adminPage() {
        return "admin-page";
    }

}
