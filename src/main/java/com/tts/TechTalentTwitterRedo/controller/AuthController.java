package com.tts.TechTalentTwitterRedo.controller;

import javax.validation.Valid;

import com.tts.TechTalentTwitterRedo.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.tts.TechTalentTwitterRedo.model.UserEntity;
import com.tts.TechTalentTwitterRedo.service.UserService;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping(value="/login")
    public String login(){
        return "login";
    }

    @GetMapping(value="/signup")
    public String registration(Model model){
        UserEntity userEntity = new UserEntity();
        model.addAttribute("user", userEntity);
        return "registration";
    }

    @PostMapping(value = "/signup")
    public String createNewUser(@Valid UserEntity user, BindingResult bindingResult, Model model) {
        UserEntity userExists = userService.findByUsername(user.getUsername());
        if (userExists != null) {
            bindingResult.rejectValue("username", "error.user", "Username is already taken");
        }
        if (!bindingResult.hasErrors()) {
            userService.saveNewUser(user);
            model.addAttribute("success", "Sign up successful!");
            model.addAttribute("user", new UserEntity());
        }
        return "registration";
    }

}

