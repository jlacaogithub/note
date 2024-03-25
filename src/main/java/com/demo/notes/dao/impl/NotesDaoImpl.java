package com.demo.notes.dao.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.demo.notes.dao.NotesDao;
import com.demo.notes.exception.NoteNotFoundException;
import com.demo.notes.model.Note;
import com.demo.notes.util.Storage;

@Component
public class NotesDaoImpl implements NotesDao{

	@Override
	public List<Note> getNotes() {
		List<Note> notes = null;
		Map<Integer, Note> userNotes = Storage.userNotes;
		notes = userNotes.entrySet()
				   .stream()
				   .map(e -> e.getValue())
				   .collect(Collectors.toList());
		return notes;
	}

	@Override
	public Note getNoteById(int noteId) {
		Note nt = null;
		
		//get notes from local storage
		Map<Integer, Note> userNotes = Storage.userNotes;
		nt = userNotes.get(noteId);
		if(nt==null) {
			throw new NoteNotFoundException();
		}
		
		return nt;
	}

	@Override
	public boolean saveNote(Note note) {
		boolean ret = false;
		//get notes from local storage
		Map<Integer, Note> userNotes = Storage.userNotes;
		note.setId(userNotes.size()+1);
		userNotes.put((userNotes.size()+1), note);
		ret=true;
		return ret;
	}

	@Override
	public boolean updateNote(Note note) {
		boolean ret = false;
		
		//get notes from local storage
		Map<Integer, Note> userNotes = Storage.userNotes;
		Note existing = userNotes.get(note.getId());
		if(existing==null) {
			throw new NoteNotFoundException();
		}else {
			userNotes.put(note.getId(), note);
			ret=true;
		}
		
		return ret;
	}

	@Override
	public boolean deleteNote(int noteId) {
		boolean ret = false;
		
		//get notes from local storage
		Map<Integer, Note> userNotes = Storage.userNotes;
		Note existing = userNotes.get(noteId);
		if(existing==null) {
			throw new NoteNotFoundException();
		}else {
			userNotes.remove(noteId);
			ret=true;
		}
		
		return ret;
	}

}
