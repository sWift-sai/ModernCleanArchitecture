package ru.swift.moderncleanarchitecture.data.remote.repository.datastore;

import rx.Observable;

public interface ExerciseCategoryDataStore<LIST> {

    Observable<LIST> getAll();

}
