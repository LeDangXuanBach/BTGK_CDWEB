package com.example.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.forum.service.ForumService;

@Controller
public class ListTopicsController {
	@Autowired
	private ForumService forumService;
	
    @GetMapping("/listTopics")
    public String listTopics(Model model) {
//    	Collection<Topic> topics = forumService.getTopics();
//    	for (Topic topic : topics) {
//			System.out.println(topic.getNewMessage().getTime());
//		}
    	model.addAttribute("topics", forumService.getTopics());
        return "listTopics";
    }

}
