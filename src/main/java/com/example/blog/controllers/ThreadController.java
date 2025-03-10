package com.example.blog.controllers;

import com.example.blog.bll.BlogThread;
import com.example.blog.services.ThreadServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="/")
@CrossOrigin(origins = "http://localhost:4200")
public class ThreadController {
    @Autowired
    private ThreadServiceImpl threadService;

    @PostMapping(value="thread")
    private ResponseEntity<?> postThread(@RequestBody BlogThread thread){
        try {
            threadService.postThread(thread);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value="thread")
    private List<BlogThread> getAllThreads() {
        try {
            return threadService.getAllThreads();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping(value="elasticsearch/thread")
    private List<BlogThread> getThreadsByText(@RequestParam String text) {
        try {
            List<String> threadIDs =  threadService.fullTextSearch(text);
            List<BlogThread> threadList = new ArrayList<BlogThread>();
            for (String ID : threadIDs) {
                BlogThread thread = threadService.getThreadById(Long.parseLong(ID));
                threadList.add(thread);
            }
            return threadList;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
