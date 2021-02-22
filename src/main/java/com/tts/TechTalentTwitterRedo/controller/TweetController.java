package com.tts.TechTalentTwitterRedo.controller;

import java.util.List;

import javax.validation.Valid;

import com.tts.TechTalentTwitterRedo.model.TweetEntity;
import com.tts.TechTalentTwitterRedo.model.UserEntity;
import com.tts.TechTalentTwitterRedo.service.TweetService;
import com.tts.TechTalentTwitterRedo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class TweetController {
    @Autowired
    private UserService userService;

    @Autowired
    private TweetService tweetService;

    @GetMapping(value= {"/tweets", "/"})
    public String getFeed(Model model){
        List<TweetEntity> tweets = tweetService.findAll();
        model.addAttribute("tweetList", tweets);
        return "feed";
    }

    @GetMapping(value = "/tweets/new")
    public String getTweetForm(Model model) {
        model.addAttribute("tweet", new TweetEntity());
        return "newTweet";
    }

    @PostMapping(value = "/tweets")
    public String submitTweetForm(@Valid TweetEntity tweet, BindingResult bindingResult, Model model) {
        UserEntity userEntity = userService.getLoggedInUser();
        if (!bindingResult.hasErrors()) {
            tweet.setUserEntity(userEntity);
            tweetService.save(tweet);
            model.addAttribute("successMessage", "Tweet successfully created!");
            model.addAttribute("tweet", new TweetEntity());
        }
        return "newTweet";
    }
}

