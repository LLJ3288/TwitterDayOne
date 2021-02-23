package com.tts.TechTalentTwitterRedo.service;

import java.util.List;
import java.util.Optional;

import com.tts.TechTalentTwitterRedo.model.TweetEntity;
import com.tts.TechTalentTwitterRedo.model.UserEntity;
import com.tts.TechTalentTwitterRedo.repo.TweetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TweetService {

    @Autowired
    private TweetRepo tweetRepo;

    public List<TweetEntity> findAll() {
        List<TweetEntity> tweets = tweetRepo.findAllByOrderByCreatedAtDesc();
        return tweets;
    }

    public List<TweetEntity> findAllByUser(UserEntity user) {
        List<TweetEntity> tweets = tweetRepo.findAllByUserOrderByCreatedAtDesc(user);
        return tweets;
    }

    public List<TweetEntity> findAllByUsers(List<UserEntity> users) {
        List<TweetEntity> tweets = tweetRepo.findAllByUserInOrderByCreatedAtDesc(users);
        return tweets;

    }

    public void save(TweetEntity tweet) {
        tweetRepo.save(tweet);
    }



    public Optional<TweetEntity> findById(Long Id) {

        return tweetRepo.findById(Id);
    }

}


