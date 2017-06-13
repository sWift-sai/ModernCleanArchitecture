package ru.swift.moderncleanarchitecture.presentation.screen.exercises;

import com.arellomobile.mvp.InjectViewState;

import java.util.List;

import ru.swift.moderncleanarchitecture.domain.interactor.GetExercises;
import ru.swift.moderncleanarchitecture.domain.model.Exercise;
import ru.swift.moderncleanarchitecture.presentation.mapper.ExerciseModelDataMapper;
import ru.swift.moderncleanarchitecture.presentation.screen.BasePresenter;
import ru.swift.moderncleanarchitecture.presentation.screen.DefaultSubscriber;
import ru.terrakok.cicerone.Router;

@InjectViewState
public class ExercisesPresenter extends BasePresenter<ExercisesContract.View>
        implements ExercisesContract.Presenter, ExercisesContract.Presenter.ExerciseClickListener {

    private final Router router;
    private final GetExercises getExercises;
    private final ExerciseModelDataMapper exerciseModelMapper;
    private final int exerciseCategoryId;

    ExercisesPresenter(Router router,
                       GetExercises getExercises,
                       ExerciseModelDataMapper exerciseModelDataMapper,
                       int exerciseCategoryId) {
        this.router = router;
        this.getExercises = getExercises;
        this.exerciseModelMapper = exerciseModelDataMapper;
        this.exerciseCategoryId = exerciseCategoryId;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        loadExercises();
    }

    private void loadExercises() {
        getViewState().showLoading();
        getExercises.execute(new GetExercises.Params(exerciseCategoryId), new ExercisesSubscriber());
    }

    @Override
    public void onExerciseClick(int exerciseId) {
        // FIXME uncomment when Exercise info screen will be implemented
        //router.navigateTo(Screens.EXERCISE_INFO_SCREEN, exerciseId);
    }

    @Override
    protected void unsubscribe() {
        getExercises.unsubscribe();
    }

    @Override
    public void onBackPressed() {
        router.exit();
    }


    private final class ExercisesSubscriber extends DefaultSubscriber<List<Exercise>> {
        @Override
        public void onNext(List<Exercise> exercises) {
            getViewState().hideLoading();
            getViewState().renderExercises(exerciseModelMapper.transform(exercises));
        }
    }
}
