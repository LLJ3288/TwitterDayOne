package com.tts.TechTalentTwitterRedo.repo;

import com.tts.TechTalentTwitterRedo.model.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<UserEntity,Long> {

    UserEntity findByUsername(String username);






}
