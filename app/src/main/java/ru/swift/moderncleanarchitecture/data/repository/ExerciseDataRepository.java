package ru.swift.moderncleanarchitecture.data.repository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import ru.swift.moderncleanarchitecture.data.remote.mapper.ExerciseRemoteDataMapper;
import ru.swift.moderncleanarchitecture.data.repository.datastore.ExerciseDataStoreFactory;
import ru.swift.moderncleanarchitecture.data.repository.datastore.ExerciseRemoteDataStore;
import ru.swift.moderncleanarchitecture.domain.model.Exercise;
import ru.swift.moderncleanarchitecture.domain.repository.ExerciseRepository;
import rx.Observable;

@Singleton
public class ExerciseDataRepository implements ExerciseRepository {

    private final ExerciseRemoteDataMapper exerciseRemoteDataMapper;
    private final ExerciseDataStoreFactory exerciseDataStoreFactory;
    private ExerciseRemoteDataStore exerciseRemoteDataStore;

    @Inject
    public ExerciseDataRepository(ExerciseRemoteDataMapper exerciseRemoteDataMapper,
                                  ExerciseDataStoreFactory exerciseDataStoreFactory) {
        this.exerciseRemoteDataMapper = exerciseRemoteDataMapper;
        this.exerciseDataStoreFactory = exerciseDataStoreFactory;
    }


    @Override
    public Observable<List<Exercise>> getAllByCategoryId(int categoryId) {
        prepareDataStores();
        return exerciseRemoteDataStore.getAllByCategoryId(categoryId)
                .map(exerciseRemoteDataMapper::transform);
    }

    private void prepareDataStores() {
        if (exerciseRemoteDataStore == null) {
            exerciseRemoteDataStore = exerciseDataStoreFactory.createRemoteDataStore();
        }
    }
}
