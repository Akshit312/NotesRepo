package com.we.springmvcboot.Model;

import java.util.List;

public class OrderResponse {

	
	private List<Notes> UserNotes;
	
	private int userID;
	
	public OrderResponse() {}
	
	public OrderResponse(List<Notes> UserNotes, int userID) {
		super();
		this.userID=userID;
		this.UserNotes=UserNotes;
	}
	
	public int getUserID() 
	{
		return userID;
	}
	
	public void setUserID(int userID)
	{
		this.userID = userID;
	}
	
	public List<Notes> getUserNotes() 
	{
		return UserNotes;
	}
	
	public void setUserNotes(List<Notes> userNotes) {
		UserNotes = userNotes;
	}
	
	@Override
	public String toString() {
		return "OrderResponse [userID=" + userID + ", UserNotes=" + UserNotes+ "]";
	}
	
	
}
