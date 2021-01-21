package com.example.blog.services;

import com.example.blog.bll.BlogThread;
import com.example.blog.repository.ThreadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThreadServiceImpl implements ThreadService{
    @Autowired
    private ThreadRepository threadRepository;

    public void postThread (BlogThread thread) {
        threadRepository.save(thread);
    }

    public List<BlogThread> getAllThreads() {
        return threadRepository.findAll();
    }
}
