package ru.swift.moderncleanarchitecture.data.repository.datastore;

import java.util.List;

import ru.swift.moderncleanarchitecture.data.remote.ExerciseApi;
import ru.swift.moderncleanarchitecture.data.remote.model.ExerciseRemote;
import ru.swift.moderncleanarchitecture.data.remote.model.PaginatedListResponse;
import rx.Observable;

public class ExerciseRemoteDataStore implements ExerciseDataStore<List<ExerciseRemote>> {

    private final ExerciseApi exerciseApi;

    public ExerciseRemoteDataStore(ExerciseApi exerciseApi) {
        this.exerciseApi = exerciseApi;
    }

    @Override
    public Observable<List<ExerciseRemote>> getAllByCategoryId(int categoryId) {
        return exerciseApi.getExercisesByCategory(categoryId)
                .map(PaginatedListResponse::getItems);
    }
}
