package com.example.forum.model;


import java.util.List;
import java.util.Stack;

public class Topic extends Entry {
	private Integer id;
	private Stack<Message> messages = new Stack<Message>();
	private Category category;

	public Topic(Integer id, String title, String content, 
	      User creator, Category category) {
		super(title, content, creator);
		this.id = id;
		this.category = category;
	}

	public Integer getId() {
		return id;
	}

	public Category getCategory() {
      return category;
   }

   public void setCategory(Category category) {
      this.category = category;
   }

   public List<Message> getMessages() {
		return messages.subList(0, messages.size());
	}

	public void addMessage(Message message) {
		messages.push(message);
	}

	public Entry getNewMessage() {
		if(messages.isEmpty()) return this;
		return messages.peek();
	}	
	
	public String getNewMessInfo() {
		Message m = messages.peek();
		return "Bài viết mới nhất by "+m.getCreator().getUsername()+", "+m.getTime();
	}
	
}
