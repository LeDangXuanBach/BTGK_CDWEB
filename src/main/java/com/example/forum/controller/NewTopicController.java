package com.example.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.forum.model.Category;
import com.example.forum.model.Topic;
import com.example.forum.model.User;
import com.example.forum.service.ForumService;

import jakarta.servlet.http.HttpSession;

@Controller
public class NewTopicController {
	@Autowired
	private ForumService forumService;
	@GetMapping("/newTopic")
	public String showNewTopic(HttpSession session, Model model) {
		if(session.getAttribute("user") != null) return "newTopic";
		model.addAttribute("errorMess", "Bạn cần đăng nhập để tạo chủ đề mới");
		return "error";
	}
	
	@PostMapping("/newTopic")
	public String newTopic(@RequestParam("title") String title, @RequestParam("content") String content, HttpSession session) {
		Topic topic = new Topic(forumService.getNextTopicID(), title, content,(User)session.getAttribute("user"), new Category("Thi Cử"));
		forumService.addTopic(topic);
		return "redirect:listTopics";
	}

}
