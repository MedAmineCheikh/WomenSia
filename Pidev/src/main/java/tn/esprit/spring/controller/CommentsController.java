package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import tn.esprit.spring.entities.Comments;
import tn.esprit.spring.services.ICommentService;

@Controller

public class CommentsController {
	
	@Autowired
	ICommentService commentService;
	
	@GetMapping("/Getcomment/{id}")
	public Comments GetCommentById(@PathVariable("id")int id){
		return commentService.GetCommentById(id);
	}
	
	@GetMapping("/hello")
	public String Hello(){
		return commentService.Hello();
	}
	
	

}
