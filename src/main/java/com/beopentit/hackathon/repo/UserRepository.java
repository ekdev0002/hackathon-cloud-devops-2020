package com.beopentit.hackathon.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.beopentit.hackathon.security.config.User;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUserName(String username);
}
