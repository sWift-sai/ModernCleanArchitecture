package ru.swift.moderncleanarchitecture.data.remote.repository.datastore;

import java.util.List;

import ru.swift.moderncleanarchitecture.data.remote.ExerciseApi;
import ru.swift.moderncleanarchitecture.data.remote.model.ExerciseCategoryRemote;
import ru.swift.moderncleanarchitecture.data.remote.model.PaginatedListResponse;
import rx.Observable;

public class ExerciseCategoryRemoteDataStore implements ExerciseCategoryDataStore<List<ExerciseCategoryRemote>> {

    private final ExerciseApi exerciseApi;

    public ExerciseCategoryRemoteDataStore(ExerciseApi exerciseApi) {
        this.exerciseApi = exerciseApi;
    }

    @Override
    public Observable<List<ExerciseCategoryRemote>> getAll() {
        return exerciseApi.getExerciseCategories()
                .map(PaginatedListResponse::getItems);
    }
}
