package ru.swift.moderncleanarchitecture.data.repository.datastore;

import javax.inject.Inject;
import javax.inject.Singleton;

import ru.swift.moderncleanarchitecture.data.remote.ExerciseApi;

@Singleton
public class ExerciseCategoryDataStoreFactory {

    private final ExerciseApi exerciseApi;

    @Inject
    public ExerciseCategoryDataStoreFactory(ExerciseApi exerciseApi) {
        this.exerciseApi = exerciseApi;
    }

    public ExerciseCategoryRemoteDataStore createRemoteDataStore() {
        return new ExerciseCategoryRemoteDataStore(exerciseApi);
    }

}
