package com.example.blog.bll;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;
    @Column(name="threadId")
    private long threadId;
    @Column(name="name")
    private String name;
    @Column(name="datetime")
    private LocalDateTime dateTime;
    @Column(name="text")
    private String text;

    public Comment(long threadId, String name, LocalDateTime dateTime, String text) {
        this.threadId = threadId;
        this.name = name;
        this.dateTime = dateTime;
        this.text = text;
    }

    public Comment() {
    }

    public long getThreadId() {
        return threadId;
    }

    public void setThreadId(long threadId) {
        this.threadId = threadId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
