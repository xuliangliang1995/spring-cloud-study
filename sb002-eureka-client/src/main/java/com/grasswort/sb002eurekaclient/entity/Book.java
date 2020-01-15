package com.grasswort.sb002eurekaclient.entity;

/**
 * @author xuliangliang
 * @Classname Book.java
 * @Description
 * @Date 2020/1/14
 * @blame Java Team
 */
public class Book {

    private Long id;

    private String name;

    private String author;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
