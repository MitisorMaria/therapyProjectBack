package com.example.blog.services;

import com.example.blog.bll.Comment;
import com.example.blog.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    private CommentRepository commentRepository;

    public void postComment(Comment comment) {
        commentRepository.save(comment);
    }

    public List<Comment> getAllCommentsByThreadId(long threadId) {
        //create example dummy object
        Comment comment = new Comment();
        comment.setThreadId(threadId);

        ExampleMatcher customExampleMatcher = ExampleMatcher.matchingAny()
                .withMatcher("threadId", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase());

        Example<Comment> example = Example.of(comment, customExampleMatcher);

        List<Comment> allComments = commentRepository.findAll(example);
        return allComments;
    }
}
