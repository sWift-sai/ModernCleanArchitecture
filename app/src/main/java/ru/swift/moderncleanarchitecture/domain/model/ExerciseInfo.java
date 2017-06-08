package ru.swift.moderncleanarchitecture.domain.model;

import java.util.List;

import lombok.Data;

@Data
public class ExerciseInfo {

    private String name;
    private ExerciseCategory category;
    private String description;
    private List<Muscle> muscles = null;
    private List<Muscle> musclesSecondary = null;
    private List<Equipment> equipment = null;

}
