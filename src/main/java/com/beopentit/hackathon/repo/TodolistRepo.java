package com.beopentit.hackathon.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.beopentit.hackathon.model.Todolist;

@Repository(value="repo")
public interface TodolistRepo extends JpaRepository<Todolist, Long> {

}
