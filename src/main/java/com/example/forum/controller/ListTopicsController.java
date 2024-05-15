package com.example.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.forum.service.ForumService;

@Controller
public class ListTopicsController {
	@Autowired
	private ForumService forumService;
	
    @GetMapping("/listTopics")
    public String listTopics() {
        return "listTopics";
    }

}
