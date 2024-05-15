package com.example.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.forum.model.Message;
import com.example.forum.model.User;
import com.example.forum.service.ForumService;

import jakarta.servlet.http.HttpSession;

@Controller
@SessionAttributes("user")
public class ReplyTopicController {
	@Autowired
	private ForumService forumService;
	
	@GetMapping("/replyTopic")
	public String showReplyTopic(@RequestParam("id") Integer id, @RequestParam("title") String title, Model model) {
		model.addAttribute("title", title);
		model.addAttribute("id", id);
		return "replyTopic";
	}
	
	@PostMapping("/replyTopic")
	public String replyTopic(@RequestParam("idTopic") Integer idTopic, @RequestParam("content") String content, @RequestParam("title") String title, HttpSession session) {
		forumService.addMessage(idTopic, new Message(title, content, (User) session.getAttribute("user")));
        return "redirect:/showTopic?id="+idTopic;
	}

}
