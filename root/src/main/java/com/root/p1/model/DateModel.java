package com.root.p1.model;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class DateModel {

    @SerializedName("yy")
    private String yyyy;
    private String mm;
    private String dd;
    private String hh;
    private String mi;
    private String ss;
    private String curr_time;
}
