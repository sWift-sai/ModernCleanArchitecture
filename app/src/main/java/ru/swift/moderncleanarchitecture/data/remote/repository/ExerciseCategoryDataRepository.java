package ru.swift.moderncleanarchitecture.data.remote.repository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import ru.swift.moderncleanarchitecture.data.remote.mapper.ExerciseCategoryRemoteDataMapper;
import ru.swift.moderncleanarchitecture.data.remote.repository.datastore.ExerciseCategoryDataStoreFactory;
import ru.swift.moderncleanarchitecture.data.remote.repository.datastore.ExerciseCategoryRemoteDataStore;
import ru.swift.moderncleanarchitecture.domain.model.ExerciseCategory;
import ru.swift.moderncleanarchitecture.domain.repository.ExerciseCategoryRepository;
import rx.Observable;

@Singleton
public class ExerciseCategoryDataRepository implements ExerciseCategoryRepository {

    private final ExerciseCategoryRemoteDataMapper exerciseCategoryRemoteDataMapper;
    private final ExerciseCategoryDataStoreFactory exerciseCategoryDataStoreFactory;
    private ExerciseCategoryRemoteDataStore exerciseCategoryRemoteDataStore;

    @Inject
    public ExerciseCategoryDataRepository(ExerciseCategoryRemoteDataMapper exerciseCategoryRemoteDataMapper,
                                          ExerciseCategoryDataStoreFactory exerciseCategoryDataStoreFactory) {
        this.exerciseCategoryRemoteDataMapper = exerciseCategoryRemoteDataMapper;
        this.exerciseCategoryDataStoreFactory = exerciseCategoryDataStoreFactory;
    }

    @Override
    public Observable<List<ExerciseCategory>> getAll() {
        prepareDataStores();
        return exerciseCategoryRemoteDataStore.getAll()
                .map(exerciseCategoryRemoteDataMapper::transform);
    }

    private void prepareDataStores() {
        if (exerciseCategoryRemoteDataStore == null) {
            exerciseCategoryRemoteDataStore = exerciseCategoryDataStoreFactory.createRemoteDataStore();
        }
    }
}
