package ru.swift.moderncleanarchitecture.data.remote.model;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class EquipmentRemote {

    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

}
