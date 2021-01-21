package com.example.blog.services;

import com.example.blog.bll.Comment;

import java.util.List;

public interface CommentService {
    void postComment(Comment comment);
    List<Comment> getAllCommentsByThreadId(long threadId);
}
