package com.example.changedaworld.util;

public class UsefulLink {
    private String name;
    private String link;
    private int imgResource;

    public UsefulLink(String name, String link, int imgResource) {
        this.name = name;
        this.link = link;
        this.imgResource = imgResource;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getImgResource() {
        return imgResource;
    }

    public void setImgResource(int imgResource) {
        this.imgResource = imgResource;
    }
}
