package com.evanbelcher.TextToText;

import java.util.ArrayList;
import java.util.Date;

public class Text {

	private Date datetime;
	private String sender;
	private ArrayList<String> message;
	
	public Text(Date datetime, String sender, ArrayList<String> message){
		this.datetime = datetime;
		this.sender = sender;
		this.message = message;
	}

	
	Date getDatetime() {
		return datetime;
	}

	
	String getSender() {
		return sender;
	}

	
	ArrayList<String> getMessage() {
		return message;
	}
	
	
	
}
