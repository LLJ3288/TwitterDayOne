package com.tts.TechTalentTwitterRedo.repo;

import java.util.List;

import com.tts.TechTalentTwitterRedo.model.TweetEntity;
import com.tts.TechTalentTwitterRedo.model.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface TweetRepo extends CrudRepository<TweetEntity, Long> {
    List<TweetEntity> findAllByOrderByCreatedAtDesc();
    List<TweetEntity> findAllByUserOrderByCreatedAtDesc(UserEntity user);
    List<TweetEntity> findAllByUserInOrderByCreatedAtDesc(List<UserEntity> users);
}
