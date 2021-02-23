package com.tts.TechTalentTwitterRedo.controller;


import com.tts.TechTalentTwitterRedo.model.RoleEntity;
import com.tts.TechTalentTwitterRedo.model.UserEntity;
import com.tts.TechTalentTwitterRedo.service.TweetService;
import com.tts.TechTalentTwitterRedo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.Arrays;
import java.util.HashSet;





//public class UserController {
//
//
//    @Autowired
//    private UserService userService;
//
//
//    @Autowired
//    private TweetService tweetService;
//
//    @GetMapping("/users/{username}")
//    public String getUser(@PathVariable("username") String username, Model model)
//
//}
//
//}
