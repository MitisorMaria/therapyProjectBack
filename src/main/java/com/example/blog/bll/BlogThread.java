package com.example.blog.bll;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="thread")
public class BlogThread {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;
    @Column(name="title")
    private String title;
    @Column(name="datetime")
    private LocalDateTime dateTime;
    @Column(name="text")
    private String text;


    public BlogThread(String title, LocalDateTime dateTime, String text) {
        this.title = title;
        this.dateTime = dateTime;
        this.text = text;
    }

    public BlogThread() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


}
