package com.tts.TechTalentTwitterRedo.service;

import java.util.List;

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

    public List<TweetEntity> findAllByUser(UserEntity userEntity) {
        List<TweetEntity> tweets = tweetRepo.findAllByUserOrderByCreatedAtDesc(userEntity);
        return tweets;
    }

    public List<TweetEntity> findAllByUsers(List<UserEntity> users){
        List<TweetEntity> tweets = tweetRepo.findAllByUserInOrderByCreatedAtDesc(users);
        return tweets;
    }

    public void save(TweetEntity tweetEntity) {
        tweetRepo.save(tweetEntity);
    }
}
