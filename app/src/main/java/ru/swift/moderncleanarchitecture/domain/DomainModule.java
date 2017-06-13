package ru.swift.moderncleanarchitecture.domain;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.swift.moderncleanarchitecture.data.repository.ExerciseCategoryDataRepository;
import ru.swift.moderncleanarchitecture.data.repository.ExerciseDataRepository;
import ru.swift.moderncleanarchitecture.domain.interactor.GetExerciseCategories;
import ru.swift.moderncleanarchitecture.domain.interactor.GetExercises;
import ru.swift.moderncleanarchitecture.domain.repository.ExerciseCategoryRepository;
import ru.swift.moderncleanarchitecture.domain.repository.ExerciseRepository;
import ru.swift.moderncleanarchitecture.domain.scheduler.IoThread;
import ru.swift.moderncleanarchitecture.domain.scheduler.UiThread;

@Module
public class DomainModule {

    // --- Interactors ---
    @Provides
    GetExerciseCategories provideGetExerciseCategories(IoThread ioThread, UiThread uiThread,
                                                       ExerciseCategoryRepository repository) {
        return new GetExerciseCategories(ioThread, uiThread, repository);
    }

    @Provides
    GetExercises provideGetExercises(IoThread ioThread, UiThread uiThread,
                                     ExerciseRepository repository) {
        return new GetExercises(ioThread, uiThread, repository);
    }


    // --- Repositories ---
    @Provides @Singleton
    ExerciseCategoryRepository provideExerciseCategoryRepository(ExerciseCategoryDataRepository repository) {
        return repository;
    }

    @Provides @Singleton
    ExerciseRepository provideExerciseRepository(ExerciseDataRepository repository) {
        return repository;
    }
}
