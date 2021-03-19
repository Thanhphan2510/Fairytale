package com.thanhpt.fairytale.Item;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Country {
    private String country_id;
    private String country_code;

    @SerializedName("country_name")
    private String country;

    public Country(String country_id, String country_code, String country) {
        this.country_id = country_id;
        this.country_code = country_code;
        this.country = country;
    }

    public String getCountry_id() {
        return country_id;
    }

    public String getCountry_code() {
        return country_code;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry_id(String country_id) {
        this.country_id = country_id;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Country() {
    }
}
