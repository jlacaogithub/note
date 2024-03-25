package com.demo.notes.service;

import java.util.List;

import com.demo.notes.model.Note;

public interface NoteService {

	/**
	 * method to get all notes
	 * @return {@link List} <{@link Note}>
	 */
	List<Note> getNotes();
	
	/**
	 * method to get specific note from the table
	 * @param noteId {@link Integer}
	 * @return @link Note}
	 */
	Note getNote(int noteId);
	
	/**
	 * method to save the notes into the table
	 * @param note {@link Note}
	 * @return {@link Boolean}
	 */
	boolean insertNote(Note note);
	
	/**
	 * method to update the notes into the table
	 * @param note {@link Note}
	 * @return {@link Boolean}
	 */
	boolean updateNote(Note note);
	
	/**
	 * method to delete the notes from the table
	 * @param noteId {@link Integer}
	 * @return {@link Boolean}
	 */
	boolean deleteNote(int noteId);
}
