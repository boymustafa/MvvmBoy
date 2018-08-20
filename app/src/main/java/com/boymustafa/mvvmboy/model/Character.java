package com.boymustafa.mvvmboy.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Character implements Serializable {

    @SerializedName("id")
    public String id;

    @SerializedName("name")
    public String name;

    @SerializedName("status")
    public String status;

    @SerializedName("species")
    public String species;

    @SerializedName("image")
    public String image;

}
