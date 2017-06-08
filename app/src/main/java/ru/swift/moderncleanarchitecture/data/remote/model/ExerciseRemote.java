package ru.swift.moderncleanarchitecture.data.remote.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Data;

@Data
public class ExerciseRemote {

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
    private int licenseId;

    @SerializedName("category")
    private int categoryId;

    @SerializedName("language")
    private int languageId;

    @SerializedName("muscles")
    private List<Integer> musclesIds;

    @SerializedName("muscles_secondary")
    private List<Integer> musclesSecondaryIds;

    @SerializedName("equipment")
    private List<Integer> equipmentIds;

}
