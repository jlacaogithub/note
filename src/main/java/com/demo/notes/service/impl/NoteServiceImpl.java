package com.demo.notes.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.notes.dao.NotesDao;
import com.demo.notes.exception.NoteNotFoundException;
import com.demo.notes.model.Note;
import com.demo.notes.service.NoteService;

@Component
public class NoteServiceImpl implements NoteService{

	@Autowired 
	 NotesDao notesDaoImpl;
	
	@Override
	public List<Note> getNotes() {
		return notesDaoImpl.getNotes();
	}

	@Override
	public Note getNote(int noteId) {
		Note nt = null;
		try {
			nt = notesDaoImpl.getNoteById(noteId);
		}catch (NoteNotFoundException e) {
			throw e;
		} catch (Exception e) {
			System.out.println("Cannot retrieve note due to internal error.");
		}
		return nt;
	}

	@Override
	public boolean insertNote(Note note) {
		return notesDaoImpl.saveNote(note);
	}

	@Override
	public boolean updateNote(Note note) {
		boolean ret = false;
		try {
			ret = notesDaoImpl.updateNote(note);
		}catch (NoteNotFoundException e) {
			throw e;
		} catch (Exception e) {
			System.out.println("Cannot update note due to internal error.");
		}
		return ret;
	}

	@Override
	public boolean deleteNote(int noteId) {
		return notesDaoImpl.deleteNote(noteId);
	}

}
