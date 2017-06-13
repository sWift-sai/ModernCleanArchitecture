package ru.swift.moderncleanarchitecture.data.repository.datastore;

import javax.inject.Inject;
import javax.inject.Singleton;

import ru.swift.moderncleanarchitecture.data.remote.ExerciseApi;

@Singleton
public class ExerciseDataStoreFactory {

    private final ExerciseApi exerciseApi;

    @Inject
    public ExerciseDataStoreFactory(ExerciseApi exerciseApi) {
        this.exerciseApi = exerciseApi;
    }

    public ExerciseRemoteDataStore createRemoteDataStore() {
        return new ExerciseRemoteDataStore(exerciseApi);
    }

}
