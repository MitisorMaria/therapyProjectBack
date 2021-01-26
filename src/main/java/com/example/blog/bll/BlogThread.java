package com.example.blog.bll;

import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="thread")
@Document(indexName = "blog")
public class BlogThread {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="title")
    @Field(type = FieldType.Text, includeInParent = true)
    private String title;
    @Column(name="datetime")
    @Field(type = FieldType.Date, format = DateFormat.date_hour_minute_second)//, pattern="YYYY-MM-DD'T'HH:mm:ss")
    private LocalDateTime dateTime;
    @Column(name="text")
    @Field(type = FieldType.Text, includeInParent = true)
    private String text;


    public BlogThread(long id, String title, LocalDateTime dateTime, String text) {
        id = id;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        id = id;
    }


}
