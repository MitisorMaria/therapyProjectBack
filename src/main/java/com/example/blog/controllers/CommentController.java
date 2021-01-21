package com.example.blog.controllers;


import com.example.blog.bll.Comment;
import com.example.blog.services.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/")
@CrossOrigin(origins = "http://localhost:4200")
public class CommentController {
    @Autowired
    private CommentServiceImpl commentService;

    @PostMapping(value="comment")
    private ResponseEntity<?> postThread(@RequestBody Comment comment){
        try {
            commentService.postComment(comment);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value="comment")
    private List<Comment> getAllCommentsByThreadId(@RequestParam long threadId){
        try {
           return commentService.getAllCommentsByThreadId(threadId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
