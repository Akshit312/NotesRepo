package com.we.springmvcboot.Model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Notes")
public class Notes {

	@Id
	private int NotesID;
	
	private String Title;
	
	private String Message;
	private Date date;
	
	public Notes() {}
	
	public Notes(int NotesID, String Title, String Message, Date date) {
		super();
		this.NotesID = NotesID;
		this.Title = Title;
		this.Message = Message;
		this.date=date;
	}

	public int getNotesID() {
		return NotesID;
	}

	public void setNotesID(int NotesID) {
		this.NotesID = NotesID;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		this.Title = title;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String Message) {
		this.Message = Message;
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
