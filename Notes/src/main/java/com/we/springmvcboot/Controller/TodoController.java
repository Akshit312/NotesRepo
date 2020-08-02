	package com.we.springmvcboot.Controller;
	
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
	import org.springframework.ui.ModelMap;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	import org.springframework.web.bind.annotation.RequestParam;
	import org.springframework.web.bind.annotation.ResponseBody;
	import org.springframework.web.bind.annotation.RestController;
	import org.springframework.web.servlet.ModelAndView;
	
	import com.fasterxml.jackson.databind.util.JSONPObject;
	import com.we.springmvcboot.Model.OrderResponse;
	import com.we.springmvcboot.Repository.UserNotesRepository;
	import com.we.springmvcboot.Service.TodoService;
	
	import antlr.collections.List;
	
	import java.sql.Date;
	import java.time.LocalDateTime;
	import java.time.LocalTime;
	import java.time.format.DateTimeFormatter;
	import java.util.HashMap;
	import java.util.Map;
	
	@Controller
	public class TodoController {
	@Autowired
	private TodoService todoservice;
	
	@RequestMapping(value = "/loginUser", method = RequestMethod.POST)
	public @ResponseBody HashMap<String, Object> createPerson(@RequestBody Map<String, String> input) 
	{
					
		String email=input.get("emailID");
	    HashMap<String, Object> map = new HashMap<>();
	    map.put("Status", 200);
	    map.put("Message", "Request Successful");
	    
	    try 
	    {
	    	if(todoservice.findNotesByEmail(email).isEmpty())
	    		map.put("Data", new OrderResponse(null,todoservice.getUserID(email)));
	    	else
	    		map.put("Data", new OrderResponse(todoservice.findNotesByEmail(email),todoservice.getUserID(email)));
	    }
	    catch(Exception e)
	    {
	    	todoservice.addUserIDinUser(email);
	    	map.put("Data",new OrderResponse(null,todoservice.getUserID(email)));
	    }
	    
	    return map;
	
	}
	
	
	@RequestMapping(value = "/alterNote", method = RequestMethod.POST)
	public @ResponseBody HashMap<String, Object> alterNote(@RequestBody Map<String, Object> input) 
	{
		int userID=(int)input.get("userID");
		
		String title=(String)input.get("title");
		
		String message=(String)input.get("message");
		
		int notesID=(int)(input.get("notesID"));
	    
		HashMap<String, Object> map = new HashMap<>();
	
	    map.put("Status", 200);
	    
	    map.put("Message", "Request Successful");
	    
	    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
		LocalDateTime now = LocalDateTime.now(); 
		java.sql.Date date=new java.sql.Date(System.currentTimeMillis());  
	
		if(notesID!=-1)
		{
			todoservice.updateNotes(title,message,date,notesID);
	    	map.put("Data", new OrderResponse(todoservice.findNotesByUserID(userID),userID));
		}
		else 
		{
			todoservice.addNotesID(userID);
			int notesId=todoservice.getLastInsertedNotesID();
			System.out.println(notesId);
			todoservice.addNotes(notesId, title, message, date);
		}
		return map;
		
	}
	
	@RequestMapping(value = "/deleteNote", method = RequestMethod.POST)
	public @ResponseBody HashMap<String, Object> deleteNote(@RequestBody Map<String, Object> input)
	{
		int userID=(int)input.get("userID");
		
		int notesID=(int)(input.get("notesID"));
		
		todoservice.deleteNoteFromNotes(notesID);
		
		todoservice.deleteNoteFromUserNotes(userID,notesID);
		
		HashMap<String, Object> map = new HashMap<>();
	
		map.put("Status", 200);
		map.put("Message", "Request Successful");
		map.put("Data",null);
		
		return map;
	}
	
	
	
	}
