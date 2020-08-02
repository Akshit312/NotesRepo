package com.we.springmvcboot.Model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="UserNotes")
public class UserNotes {
	
	private int userID;
	
	@Id
	private int NotesID;
	
	public UserNotes() {}
	
	public UserNotes(int userID, int NotesID) 
	{
		super();
		
		this.userID=userID;
		
		this.NotesID=NotesID;
	}
	
	public int getUserID() 
	{
		return userID;
	}

	public void setUserID(int userID) 
	{
		this.userID = userID;
	}

	public int getNotesID() 
	{
		return NotesID;
	}

	public void setNotesID(int notesID) 
	{
		this.NotesID = notesID;
	}


	
	
	
}
