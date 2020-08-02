package com.we.springmvcboot.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.we.springmvcboot.Model.Notes;
import com.we.springmvcboot.Model.OrderResponse;
import com.we.springmvcboot.Model.User;
import com.we.springmvcboot.Repository.UserRepository;

	@Service
	public class TodoService {

	@Autowired UserRepository userrepo;
	
	public List<Notes> findNotesByEmail(String email) {
		return userrepo.findNotesByEmail(email);
		
	}
	public int getUserID(String email) {
		return userrepo.getUserIDfromEmail(email);
	}
	public void addUserIDinUser(String email) {
		userrepo.addEmail(email);
	}
	public void updateNotes(String title, String message, java.sql.Date date,int notesID) {
		userrepo.updateNotes(title,message, date,notesID);
	}
	public List<Notes> findNotesByUserID(int userID) {
		return userrepo.findNotesByUserID(userID);
	}
	public void addNotesID(int userID) {
		userrepo.generateNotesID( userID);
		
	}
	public int getLastInsertedNotesID() {
		return userrepo.getNotesID();
	}
	public void addNotes(int notesId, String title, String message, java.sql.Date date) {
		userrepo.addNotes(notesId,  title,  message,  date);
		
	}
	public void deleteNoteFromNotes(int notesID) {
		// TODO Auto-generated method stub
		userrepo.deleteNoteFromNotes(notesID);
		
	}
	public void deleteNoteFromUserNotes(int userID, int notesID) {
		// TODO Auto-generated method stub
		userrepo.deleteNoteFromUserNotes(userID,notesID);
	}
	
	
	}


