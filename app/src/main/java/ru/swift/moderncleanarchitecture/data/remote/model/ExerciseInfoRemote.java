package ru.swift.moderncleanarchitecture.data.remote.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Data;

@Data
public class ExerciseInfoRemote {

    @SerializedName("name")
    private String name;

    @SerializedName("category")
    private ExerciseCategoryRemote category;

    @SerializedName("description")
    private String description;

    @SerializedName("muscles")
    private List<MuscleRemote> muscles;

    @SerializedName("muscles_secondary")
    private List<MuscleRemote> musclesSecondary;

    @SerializedName("equipment")
    private List<EquipmentRemote> equipmentList;
}
