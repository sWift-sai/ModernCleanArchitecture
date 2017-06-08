package ru.swift.moderncleanarchitecture.data.remote.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Data;

@Data
public class Exercise {

    @SerializedName("id")
    private int id;

    @SerializedName("license_author")
    private String licenseAuthor;

    @SerializedName("status")
    private String status;

    @SerializedName("description")
    private String description;

    @SerializedName("name")
    private String name;

    @SerializedName("name_original")
    private String nameOriginal;

    @SerializedName("creation_date")
    private String creationDate;

    @SerializedName("uuid")
    private String uuid;

    @SerializedName("license")
    private int license;

    @SerializedName("category")
    private int category;

    @SerializedName("language")
    private int language;

    @SerializedName("muscles")
    private List<Integer> muscles = null;

    @SerializedName("muscles_secondary")
    private List<Integer> musclesSecondary = null;

    @SerializedName("equipment")
    private List<Integer> equipment = null;

}
