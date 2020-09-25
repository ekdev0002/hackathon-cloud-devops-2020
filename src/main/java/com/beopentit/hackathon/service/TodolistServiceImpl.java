package com.beopentit.hackathon.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.beopentit.hackathon.controller.TodolistDto;
import com.beopentit.hackathon.model.Todolist;
import com.beopentit.hackathon.repo.TodolistRepo;

@Component
public class TodolistServiceImpl implements TodolistService{
	
	
	
	@Autowired
	TodolistRepo repo;
	private ModelMapper modelMapper = new ModelMapper();
	
	@Override
	public TodolistDto save(TodolistDto entity) {
		
		Todolist todo =modelMapper.map(entity, Todolist.class);
		entity = modelMapper.map(repo.save(todo),TodolistDto.class);
		return entity;
	}

	@Override
	public TodolistDto update(TodolistDto entity) {
		Todolist todo =modelMapper.map(entity, Todolist.class);
		entity = modelMapper.map(repo.save(todo),TodolistDto.class);
		return entity;
		}

	@Override
	public TodolistDto retrieve(Long itemId) {
		TodolistDto todo = modelMapper.map(repo.findById(itemId).get(),TodolistDto.class);
		return todo;
	}

	@Override
	public List<TodolistDto> retrieveAll() {
		List<Todolist> todos = repo.findAll();
		List<TodolistDto> listDto = modelMapper.map(todos, new TypeToken<List<Todolist>>() {}.getType());
		return listDto;
	}

	@Override
	public TodolistDto delete(Long itemId) {
		Todolist todo =modelMapper.map(repo.findById(itemId), Todolist.class);
		repo.deleteById(itemId);
		TodolistDto entity = modelMapper.map(todo,TodolistDto.class);
		return entity;
	}

}
