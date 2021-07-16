package com.example.e_commerce.model;

public class Course {
    int id;
    String img, title, date, level, bgColor;

    public Course(int id, String img, String title, String date, String level, String bgColor) {
        this.id = id;
        this.img = img;
        this.title = title;
        this.date = date;
        this.level = level;
        this.bgColor = bgColor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getBgColor() {
        return bgColor;
    }

    public void setBgColor(String bgColor) {
        this.bgColor = bgColor;
    }
}
