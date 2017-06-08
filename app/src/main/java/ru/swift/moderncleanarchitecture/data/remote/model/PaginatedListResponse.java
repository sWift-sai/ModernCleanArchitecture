package ru.swift.moderncleanarchitecture.data.remote.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PaginatedListResponse<T> {

    @SerializedName("count")
    private int count;

    @SerializedName("next")
    private String next;

    @SerializedName("previous")
    private String previous;

    @SerializedName("results")
    private List<T> items;
}
