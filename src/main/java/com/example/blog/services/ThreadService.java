package com.example.blog.services;

import com.example.blog.bll.BlogThread;
import org.springframework.data.domain.Page;

import java.io.IOException;
import java.util.List;

public interface ThreadService {

    void postThread (BlogThread thread);

    List<BlogThread> getAllThreads();

    List<String> fullTextSearch (String sample) throws IOException;

    BlogThread getThreadById(Long id);
}
