package ru.swift.moderncleanarchitecture.presentation.model;

import java.util.List;

import lombok.Data;

@Data
public class ExerciseInfoModel {

    private String name;
    private ExerciseCategoryModel category;
    private String description;
    private List<MuscleModel> muscles;
    private List<MuscleModel> musclesSecondary;
    private List<EquipmentModel> equipmentList;

}
