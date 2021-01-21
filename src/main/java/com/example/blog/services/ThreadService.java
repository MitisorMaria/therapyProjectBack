package com.example.blog.services;

import com.example.blog.bll.BlogThread;

import java.util.List;

public interface ThreadService {

    void postThread (BlogThread thread);

    List<BlogThread> getAllThreads();
}
