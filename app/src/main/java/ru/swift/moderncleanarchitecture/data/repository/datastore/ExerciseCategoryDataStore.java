package ru.swift.moderncleanarchitecture.data.repository.datastore;

import rx.Observable;

public interface ExerciseCategoryDataStore<LIST> {

    Observable<LIST> getAll();

}
