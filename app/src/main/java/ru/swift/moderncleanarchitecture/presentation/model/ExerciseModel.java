package ru.swift.moderncleanarchitecture.presentation.model;

import lombok.Data;

@Data
public class ExerciseModel {

    private int id;
    private String description;
    private String name;
    private int categoryId;

}
