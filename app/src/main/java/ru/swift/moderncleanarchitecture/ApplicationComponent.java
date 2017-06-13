package ru.swift.moderncleanarchitecture;

import javax.inject.Singleton;

import dagger.Component;
import ru.swift.moderncleanarchitecture.data.remote.RemoteModule;
import ru.swift.moderncleanarchitecture.domain.DomainModule;
import ru.swift.moderncleanarchitecture.domain.interactor.GetExerciseCategories;
import ru.swift.moderncleanarchitecture.domain.interactor.GetExercises;
import ru.swift.moderncleanarchitecture.presentation.PresentationModule;
import ru.swift.moderncleanarchitecture.presentation.mapper.ExerciseCategoryModelDataMapper;
import ru.swift.moderncleanarchitecture.presentation.mapper.ExerciseInfoModelDataMapper;
import ru.swift.moderncleanarchitecture.presentation.mapper.ExerciseModelDataMapper;
import ru.swift.moderncleanarchitecture.presentation.navigation.NavigationModule;
import ru.swift.moderncleanarchitecture.presentation.screen.categories.ExerciseCategoriesFragment;
import ru.swift.moderncleanarchitecture.presentation.screen.exercises.ExercisesFragment;
import ru.swift.moderncleanarchitecture.presentation.screen.main.MainActivity;
import ru.terrakok.cicerone.Router;

@Singleton
@Component(modules = {
        RemoteModule.class,
        DomainModule.class,
        PresentationModule.class,
        NavigationModule.class
})
public interface ApplicationComponent {

    void inject(ModernApplication application);
    void inject(MainActivity activity);
    void inject(ExerciseCategoriesFragment exerciseCategoriesFragment);
    void inject(ExercisesFragment exercisesFragment);

    // Mappers
    ExerciseCategoryModelDataMapper provideExerciseCategoryModelDataMapper();
    ExerciseModelDataMapper provideExerciseModelDataMapper();
    ExerciseInfoModelDataMapper provideExerciseInfoModelDataMapper();

    // Navigation
    Router provideRouter();

    // Domain
    GetExerciseCategories provideGetExerciseCategories();
    GetExercises provideGetExercises();

}
