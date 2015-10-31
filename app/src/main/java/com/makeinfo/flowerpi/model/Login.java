package com.makeinfo.flowerpi.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Login {
    @Expose
    String id;
    @Expose
    String first_name;
    @Expose
    String last_name;
    @Expose
    String profile_img;
    @Expose
    String path;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getProfile_img() {
        return profile_img;
    }

    public void setProfile_img(String profile_img) {
        this.profile_img = profile_img;
    }
}