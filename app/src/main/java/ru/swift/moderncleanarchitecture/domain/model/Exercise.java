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
    private int licenseId;
    private int categoryId;
    private int languageId;
    private List<Integer> musclesIds;
    private List<Integer> musclesSecondaryIds;
    private List<Integer> equipmentIds;

}
