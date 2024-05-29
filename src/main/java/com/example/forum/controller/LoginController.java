package com.example.forum.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.example.forum.model.User;
import com.example.forum.service.ForumService;

import jakarta.servlet.http.HttpSession;

@Controller
@SessionAttributes("user")
public class LoginController {
	@Autowired
	private ForumService forumService;
    
	
    @GetMapping("/login")
    public String logIn() {
        return "login";
    }
    
    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session, Model model) {
    	if (username == null || password == null || username.isEmpty() || password.isEmpty()) {
    		model.addAttribute("error", "Tên đăng nhập và mật khẩu không được để trống");
    		return "login";
    	}
        // Xử lý đăng nhập
    	User user = forumService.checkUser(username, password);
    	if (user != null) {
    		session.setAttribute("user", user);
            return "redirect:/listTopics";
        } else {
            model.addAttribute("error", "Tên người dùng hoặc mật khẩu không đúng");
            return "login"; // Trả về lại view "login" với thông báo lỗi
        }
    }

    @GetMapping("/logout")
    public String logout(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return "redirect:/login";
    }
}
