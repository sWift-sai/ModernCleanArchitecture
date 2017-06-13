package ru.swift.moderncleanarchitecture.presentation.screen.exercises;

import java.util.List;

import ru.swift.moderncleanarchitecture.presentation.model.ExerciseModel;
import ru.swift.moderncleanarchitecture.presentation.screen.LoadDataView;

interface ExercisesContract {

    interface View extends LoadDataView {
        void renderExercises(List<ExerciseModel> exerciseModels);
    }

    interface Presenter {

        void onBackPressed();

        interface ExerciseClickListener {
            void onExerciseClick(int exerciseId);
        }
    }
}
