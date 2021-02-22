package com.tts.TechTalentTwitterRedo.repo;

import com.tts.TechTalentTwitterRedo.model.RoleEntity;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepo extends CrudRepository<RoleEntity, Long> {

    RoleEntity findByRole(String role);
}

