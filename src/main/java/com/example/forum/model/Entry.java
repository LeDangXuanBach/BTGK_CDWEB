package com.example.forum.model;


import java.text.SimpleDateFormat;
import java.util.Calendar;

public abstract class Entry {
	protected String title;
	protected String content;
	protected Calendar createdTime;
	protected User creator;

	public Entry(String title, String content, User creator) {
		this.title = title;
		this.content = content;
		this.creator = creator;
		createdTime = Calendar.getInstance();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Calendar getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Calendar createdTime) {
		this.createdTime = createdTime;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}
	
	public String getTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy h:mm a");
        return dateFormat.format(this.createdTime.getTime());
	}
}
