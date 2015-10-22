package com.example.huawei.easytrade.Model;

/**
 * Created by huawei on 21/10/15.
 */
public class Game {

    private String name;
    private String description;
    private String platform;
    private String category;
    private String photo;

    public Game(String name, String description, String platform, String category, String photo) {
        this.name = name;
        this.description = description;
        this.platform = platform;
        this.category = category;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getPlatform() {
        return platform;
    }

    public String getCategory() {
        return category;
    }

    public String getPhoto() {
        return photo;
    }
}
