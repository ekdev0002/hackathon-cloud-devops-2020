package com.beopentit.hackathon;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.beopentit.hackathon.repo.UserRepository;
import com.beopentit.hackathon.security.config.User;

@SpringBootApplication
public class HackathonRestApiApplication {

    @Autowired
    private UserRepository repository;

    @PostConstruct
    public void initUsers() {
        List<User> users = Stream.of(
                new User(101, "saliou", "password", "saliou@gmail.com"),
                new User(102, "inonce", "password", "inonce@gmail.com"),
                new User(103, "eric", "password", "eric@gmail.com"),
                new User(104, "user", "password", "user@gmail.com")
        ).collect(Collectors.toList());
        repository.saveAll(users);
    }
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(HackathonRestApiApplication.class, args);
	}

}
