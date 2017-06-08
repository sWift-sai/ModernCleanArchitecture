package ru.swift.moderncleanarchitecture.domain.model;

import java.util.List;

import lombok.Data;

@Data
public class Exercise {

    private int id;
    private String licenseAuthor;
    private String status;
    private String description;
    private String name;
    private String nameOriginal;
    private String creationDate;
    private String uuid;
    private int license;
    private int category;
    private int language;
    private List<Integer> muscles = null;
    private List<Integer> musclesSecondary = null;
    private List<Integer> equipment = null;

}
