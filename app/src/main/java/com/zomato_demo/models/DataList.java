package com.zomato_demo.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class List {

    @SerializedName("category")
    @Expose
    private Category category;
}
