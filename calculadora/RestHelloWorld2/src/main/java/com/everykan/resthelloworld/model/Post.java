package com.everykan.resthelloworld.model;


import com.google.gson.annotations.SerializedName;

public class Post {

    private Integer id;
    private int userId;
    private String title;

    @SerializedName("body")
    private String text;

    // constructor

    public Post(){

    }

    public Post(int userId, String title, String text){
        this.userId = userId;
        this.title = title;
        this.text = text;
    }

    // Generate Getter and Setter

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    // Generate toString .....

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", userId=" + userId +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
