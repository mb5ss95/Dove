package com.example.dove;


public class ListItemModel {
    private String title;
    private String content;

    public ListItemModel(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
