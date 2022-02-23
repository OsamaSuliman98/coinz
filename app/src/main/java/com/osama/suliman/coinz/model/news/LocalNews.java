package com.osama.suliman.coinz.model.news;

import java.io.Serializable;

public class LocalNews implements Serializable {

   private int id ;
    private String title ;
    private String details ;
    private int img_news ;
    private String date ;

    public LocalNews(int id, String title, int img_news, String date) {
        this.id = id;
        this.title = title;
        this.img_news = img_news;
        this.date = date;
    }

    public LocalNews(int id, String title, String details, int img_news, String date) {
        this.id = id ;
        this.title = title;
        this.details = details;
        this.img_news = img_news;
        this.date = date;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getImg_news() {
        return img_news;
    }

    public void setImg_news(int img_news) {
        this.img_news = img_news;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


}
