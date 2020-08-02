package com.we.springmvcboot.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="User")
public class User {
	@Id
	private int UserID;
	
	private String EmailID;

	public User() {}
	
	public User(int UserID, String EmailID)
	{
		super();
	
		this.UserID = UserID;
		
		this.EmailID = EmailID;
	}
	
	public int getUserID()
	{
		return UserID;
	}
	
	public void setUserID(int UserID) 
	{
		this.UserID = UserID;
	}
	
	public String getEmailID() 
	{
		return EmailID;
	}
	
	public void setEmailID(String EmailID) 
	{
		this.EmailID = EmailID;
	}
	
	
}
