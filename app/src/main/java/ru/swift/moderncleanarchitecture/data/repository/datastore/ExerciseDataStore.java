package ru.swift.moderncleanarchitecture.data.repository.datastore;

import rx.Observable;

public interface ExerciseDataStore<LIST> {

    Observable<LIST> getAllByCategoryId(int categoryId);

}
