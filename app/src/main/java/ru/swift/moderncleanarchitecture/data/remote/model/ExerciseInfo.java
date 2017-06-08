package ru.swift.moderncleanarchitecture.data.remote.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Data;
import ru.swift.moderncleanarchitecture.domain.model.Equipment;
import ru.swift.moderncleanarchitecture.domain.model.ExerciseCategory;

@Data
public class ExerciseInfo {

    @SerializedName("name")
    private String name;

    @SerializedName("category")
    private ExerciseCategory category;

    @SerializedName("description")
    private String description;

    @SerializedName("muscles")
    private List<Muscle> muscles = null;

    @SerializedName("muscles_secondary")
    private List<Muscle> musclesSecondary = null;

    @SerializedName("equipment")
    private List<Equipment> equipment = null;
}
