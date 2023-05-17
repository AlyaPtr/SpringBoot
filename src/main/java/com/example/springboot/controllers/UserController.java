package com.example.springboot.controllers;

import com.example.springboot.models.User;
import com.example.springboot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/")
    public String HelloWorld(ModelMap modelMap) {
        modelMap.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @PostMapping(value="/create")
    public String addUser(User user, ModelMap modelMap) {
        userService.add(user);
        modelMap.addAttribute("users", userService.getAllUsers());
        return "redirect:/";
    }

    @GetMapping(value="/delete/{id}")
    public String removeUser(@PathVariable(value = "id") long id) {
        userService.removeUser(id);
        return "redirect:/";
    }

    @GetMapping(value = "/edit/{id}")
    public String showEditForm(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "edit";
    }

    @PostMapping(value = "/edit/{id}")
    public String editUser(@PathVariable long id, User user) {
        userService.editUser(user);
        return "edit";
    }
}
