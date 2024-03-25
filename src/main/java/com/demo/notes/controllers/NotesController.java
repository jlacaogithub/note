package com.demo.notes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.notes.model.Note;
import com.demo.notes.service.NoteService;

import io.swagger.annotations.ApiOperation;

@RestController
public class NotesController {

	@Autowired
	NoteService noteServiceImpl; 
	
	@ApiOperation(value = "API to create a new note.", notes = "Accepts note details and returns status code.",
			response = HttpStatus.class, responseContainer = "Json", consumes = "application/json")
	@PostMapping(value = "/notes")
	@ResponseBody
	public ResponseEntity<Object> inserNote(@RequestBody Note note) {
		String method = "inserNote()";
		System.out.println("in:: " + method);
		ResponseEntity<Object> ret = null;
		if(noteServiceImpl.insertNote(note)) {
			ret =  new ResponseEntity<>("Note successfully saved", HttpStatus.OK);
		}else {
			ret =  new ResponseEntity<>("Cannot save note", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		System.out.println("out:: " + method);
		return ret;
		
	}
	
	@ApiOperation(value = "API to get all notes.", notes = "Returns note information.",
			response = Note.class, responseContainer = "Json", consumes = "application/json")
	@GetMapping(value = "/notes")
	@ResponseBody
	public ResponseEntity<Object> getAllNotes() {
		String method = "getAllNotes()";
		System.out.println("in:: " + method);
		ResponseEntity<Object> ret = null;
		ret =  new ResponseEntity<>(noteServiceImpl.getNotes(), HttpStatus.OK);
		System.out.println("out:: " + method);
		return ret;
		
	}
	
	@ApiOperation(value = "API to get single note.", notes = "Returns note information.",
			response = Note.class, responseContainer = "Json", consumes = "application/json")
	@GetMapping(value = "/notes/{id}")
	@ResponseBody
	public ResponseEntity<Object> getNote(@PathVariable("id") int id) {
		String method = "getNote()";
		System.out.println("in:: " + method);
		ResponseEntity<Object> ret = null;
		ret =  new ResponseEntity<>(noteServiceImpl.getNote(id), HttpStatus.OK);
		System.out.println("out:: " + method);
		return ret;
		
	}
	
	@ApiOperation(value = "API to update note.", notes = "Returns update status.",
			response = String.class, responseContainer = "Json", consumes = "application/json")
	@PutMapping(value = "/notes/{id}")
	@ResponseBody
	public ResponseEntity<Object> updateNote(@PathVariable("id") int id, @RequestBody Note note) {
		String method = "updateNote()";
		System.out.println("in:: " + method);
		ResponseEntity<Object> ret = null;
		note.setId(id);
		if(noteServiceImpl.updateNote(note)) {
			ret =  new ResponseEntity<>("Note successfully updated", HttpStatus.OK);
		}else {
			ret =  new ResponseEntity<>("Cannot update note due to internal error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		System.out.println("out:: " + method);
		return ret;
		
	}
	
	@ApiOperation(value = "API to delete note.", notes = "Returns delete status.",
			response = String.class, responseContainer = "Json", consumes = "application/json")
	@DeleteMapping(value = "/notes/{id}")
	@ResponseBody
	public ResponseEntity<Object> deleteNote(@PathVariable("id") int id) {
		String method = "deleteNote()";
		System.out.println("in:: " + method);
		ResponseEntity<Object> ret = null;
		if(noteServiceImpl.deleteNote(id)) {
			ret =  new ResponseEntity<>("Note successfully delete", HttpStatus.OK);
		}else {
			ret =  new ResponseEntity<>("Cannot delete note due to internal error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		System.out.println("out:: " + method);
		return ret;
		
	}
}
