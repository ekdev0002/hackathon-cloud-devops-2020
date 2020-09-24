package com.beopentit.hackathon.service;

import java.util.List;

import com.beopentit.hackathon.controller.TodolistDto;

public interface TodolistService {

	public TodolistDto save(TodolistDto entity);
	public TodolistDto update(TodolistDto entity);
	public TodolistDto retrieve(Long itemId);
	public List<TodolistDto> retrieveAll();
	public TodolistDto delete(Long entity);
	
	
}
