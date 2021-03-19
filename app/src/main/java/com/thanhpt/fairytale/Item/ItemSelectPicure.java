package com.thanhpt.fairytale.Item;

import android.content.Context;

public class ItemSelectPicure {
    private String comment,title;
    private float rate;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public ItemSelectPicure(String comment, String title, float rate) {

        this.comment = comment;
        this.title = title;
        this.rate = rate;
    }
}
