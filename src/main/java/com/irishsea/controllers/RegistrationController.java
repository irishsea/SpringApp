package com.irishsea.controllers;


import com.irishsea.entity.User;
import com.irishsea.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;


@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("form", new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String performRegistration(@ModelAttribute("form") User form, Model model) {
        if (!userService.saveUser(form)) {
            model.addAttribute("usernameError", "Пользователь с таким именем уже зарегистрирован");
            return "registration";
        }

        return "redirect:/home";
    }
}
