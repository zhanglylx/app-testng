package com.cxb.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

public class AppBook implements Serializable {
    private String name;
    private String author;
    private String summary;
    private Integer x;
    private Integer y;
    private String readProgress;
    private Boolean update;

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

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }




    public String getReadProgress() {
        return readProgress;
    }

    public void setReadProgress(String readProgress) {
        this.readProgress = readProgress;
    }

    public Boolean getUpdate() {
        return update;
    }

    public void setUpdate(Boolean update) {
        this.update = update;
    }

    @Override
    public String toString() {
        return "AppBook{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", summary='" + summary + '\'' +
                ", x=" + x +
                ", y=" + y +
                ", readProgress='" + readProgress + '\'' +
                ", update=" + update +
                '}';
    }
}
