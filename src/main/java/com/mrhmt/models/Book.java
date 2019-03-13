package com.mrhmt.models;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Book {
    private int id;
    private String name;
    @DateTimeFormat(pattern = "MM-dd-yyyy")
    private Date releasedate;
    private String author;

    public Book() {
    }

    public Book(int id, String name, Date releasedate, String author) {
        this.id = id;
        this.name = name;
        this.releasedate = releasedate;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getReleasedate() {
        return releasedate;
    }

    public void setReleasedate(Date releasedate) {
        this.releasedate = releasedate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
