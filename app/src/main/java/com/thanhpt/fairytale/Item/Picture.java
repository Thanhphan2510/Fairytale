package com.thanhpt.fairytale.Item;

import android.widget.ImageView;
import android.widget.TextView;

public class Picture {
    private int imageView;
    private String textView;

    public void setImageView(int imageView) {
        this.imageView = imageView;
    }

    public void setTextView(String textView) {
        this.textView = textView;
    }

    public int getImageView() {

        return imageView;
    }

    public String getTextView() {
        return textView;
    }

    public Picture(int imageView, String textView) {

        this.imageView = imageView;
        this.textView = textView;
    }
}
