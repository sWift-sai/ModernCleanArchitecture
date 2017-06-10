package ru.swift.moderncleanarchitecture.presentation;

import dagger.Module;
import dagger.Provides;
import ru.swift.moderncleanarchitecture.presentation.mapper.ExerciseCategoryModelDataMapper;
import ru.swift.moderncleanarchitecture.presentation.mapper.ExerciseInfoModelDataMapper;
import ru.swift.moderncleanarchitecture.presentation.mapper.ExerciseModelDataMapper;

@Module
public class PresentationModule {

    // --- Mappers ---
    @Provides
    ExerciseCategoryModelDataMapper provideExerciseCategoryModelDataMapper() {
        return ExerciseCategoryModelDataMapper.INSTANCE;
    }

    @Provides
    ExerciseModelDataMapper provideExerciseModelDataMapper() {
        return ExerciseModelDataMapper.INSTANCE;
    }

    @Provides
    ExerciseInfoModelDataMapper provideExerciseInfoModelDataMapper() {
        return ExerciseInfoModelDataMapper.INSTANCE;
    }
}
