package ru.swift.moderncleanarchitecture.data.remote.model;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class Muscle {

    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    @SerializedName("is_front")
    private boolean isFront;

}
