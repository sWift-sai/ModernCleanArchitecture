package ru.swift.moderncleanarchitecture.presentation.screen.categories;

import java.util.List;

import ru.swift.moderncleanarchitecture.presentation.model.ExerciseCategoryModel;
import ru.swift.moderncleanarchitecture.presentation.screen.LoadDataView;

interface ExerciseCategoriesContract {

    interface View extends LoadDataView {
        void renderExerciseCategories(List<ExerciseCategoryModel> exerciseCategoryModels);
    }

    interface Presenter {

        interface ExerciseCategoryClickListener {
            void onExerciseCategoryClick(int exerciseCategoryId);
        }
    }

}
