package com.example.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.forum.model.Message;
import com.example.forum.model.Topic;
import com.example.forum.service.ForumService;

@Controller
public class ShowTopicController {
	@Autowired
	private ForumService forumService;
	
	@GetMapping("/showTopic")
	public String showTopic(@RequestParam("id") Integer id, Model model) {
		Topic topic = forumService.findTopic(id);
		model.addAttribute("topic", topic);
		return "showTopic";
	}

}
