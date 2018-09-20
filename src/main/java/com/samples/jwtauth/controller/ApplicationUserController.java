package com.samples.jwtauth.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.samples.jwtauth.dto.UserCountInfo;
import java.util.List;

import com.samples.jwtauth.jparepository.ApplicationUserRepository;
import com.samples.jwtauth.model.ApplicationUser;

@RestController
@RequestMapping("/users")
public class ApplicationUserController {
	
	@Autowired
    private ApplicationUserRepository applicationUserRepository;
	
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    public ApplicationUserController(ApplicationUserRepository applicationUserRepository,
                          BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.applicationUserRepository = applicationUserRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    @PostMapping("/sign-up")
    public void signUp(@RequestBody ApplicationUser user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        applicationUserRepository.save(user);
    }
    
    @GetMapping("/count")
    public List<UserCountInfo> getUserCountInfo() {
    	return applicationUserRepository.getUserCountInfo();
    }
}