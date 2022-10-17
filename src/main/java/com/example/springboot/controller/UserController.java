package com.example.springboot.controller;

import com.example.springboot.model.User;
import com.example.springboot.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String allUsers(Model model) {
        model.addAttribute("user", service.getAll());
        return "index";
    }

    @GetMapping("/create")
    public String createUserForm(@ModelAttribute User user) {
        return "/create";
    }

    @PostMapping("/add")
    public String createUser(@ModelAttribute User user) {
        service.add(user);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String editUser(@PathVariable long id, Model model) {
        model.addAttribute("user", service.getById(id));
        return "/update";
    }

    @PostMapping("/updateUser/{id}")
    public String updateUser(@ModelAttribute User user) {
        service.update(user);
        return "redirect:/";
    }

    @GetMapping ("/delete/{id}")
    public String delete(@ModelAttribute User user, @PathVariable long id){
        service.delete(id);
        return "redirect:/";
    }

}