package com.beopentit.hackathon.controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.beopentit.hackathon.service.TodolistService;

@RestController
@RequestMapping("/todolist")
public class HackathonController {

	@Autowired
	TodolistService todoService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(HackathonController.class);
	
	@GetMapping(value = "/{itemId}")
	public ResponseEntity<TodolistDto> retrieveTodolistDto(@PathVariable Long itemId) {
		return new ResponseEntity<TodolistDto>(todoService.retrieve(itemId), HttpStatus.OK);		
	}

	@GetMapping
	public ResponseEntity<List<TodolistDto>> retrieveAllTodolistDto() {
		return new ResponseEntity<List<TodolistDto>>( todoService.retrieveAll(), HttpStatus.OK);		
	}

	
	@PostMapping
	public ResponseEntity<TodolistDto> registerTodolistDto(@RequestBody TodolistDto todolistDto) {
			
			return new ResponseEntity<TodolistDto>(todoService.save(todolistDto), HttpStatus.CREATED);
	}

		
	@RequestMapping(value = "/{itemId}", method = {RequestMethod.PUT})
    public ResponseEntity<TodolistDto> updateTodolistDto(@PathVariable(required = true) Long itemId, 
    											  @RequestBody TodolistDto todolistDto) {
		todolistDto.setId(itemId);
		return new ResponseEntity<TodolistDto>(todoService.update(todolistDto), HttpStatus.OK);
		
    }

		
	@DeleteMapping(value = "/{itemId}")
	public ResponseEntity<TodolistDto> inactivateTodolistDto(@PathVariable(required = true) Long itemId) {
		TodolistDto item=null;
		todoService.delete(itemId);	
		return new ResponseEntity<TodolistDto>(item, HttpStatus.NO_CONTENT);
	}
	
}
