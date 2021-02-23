package com.tts.TechTalentTwitterRedo.service;

import com.tts.TechTalentTwitterRedo.model.RoleEntity;
import com.tts.TechTalentTwitterRedo.model.UserEntity;
import com.tts.TechTalentTwitterRedo.repo.RoleRepo;
import com.tts.TechTalentTwitterRedo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
public class UserService {

    private UserRepo userRepo;
    private RoleRepo roleRepo;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(UserRepo userRepo,
                       RoleRepo roleRepository,
                       BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public UserEntity findByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    public List<UserEntity> findAll(){
        return (List<UserEntity>) userRepo.findAll();
    }

    public void save(UserEntity userEntity) {
        userRepo.save(userEntity);
    }


    public UserEntity getLoggedInUser() {
        String loggedInUsername = SecurityContextHolder.
                getContext().getAuthentication().getName();

        return findByUsername(loggedInUsername);
    }





    public UserEntity saveNewUser(UserEntity userEntity) {
        userEntity.setPassword(bCryptPasswordEncoder.encode(userEntity.getPassword()));
        userEntity.setActive(1);
        RoleEntity userRole = roleRepo.findByRole("USER");
        userEntity.setRoles(new HashSet<RoleEntity>(Arrays.asList(userRole)));
        return userRepo.save(userEntity);
    }
}

