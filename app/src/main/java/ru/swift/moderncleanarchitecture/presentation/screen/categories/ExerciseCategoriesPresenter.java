package ru.swift.moderncleanarchitecture.presentation.screen.categories;

import com.arellomobile.mvp.InjectViewState;

import java.util.List;

import ru.swift.moderncleanarchitecture.domain.interactor.GetExerciseCategories;
import ru.swift.moderncleanarchitecture.domain.model.ExerciseCategory;
import ru.swift.moderncleanarchitecture.presentation.mapper.ExerciseCategoryModelDataMapper;
import ru.swift.moderncleanarchitecture.presentation.navigation.Screens;
import ru.swift.moderncleanarchitecture.presentation.screen.BasePresenter;
import ru.swift.moderncleanarchitecture.presentation.screen.DefaultSubscriber;
import ru.terrakok.cicerone.Router;

@InjectViewState
public class ExerciseCategoriesPresenter extends BasePresenter<ExerciseCategoriesContract.View>
        implements ExerciseCategoriesContract.Presenter,
        ExerciseCategoriesContract.Presenter.ExerciseCategoryClickListener {

    private final Router router;
    private final GetExerciseCategories getExerciseCategories;
    private final ExerciseCategoryModelDataMapper exerciseCategoryModelMapper;

    ExerciseCategoriesPresenter(Router router,
                                GetExerciseCategories getExerciseCategories,
                                ExerciseCategoryModelDataMapper exerciseCategoryModelDataMapper) {
        this.router = router;
        this.getExerciseCategories = getExerciseCategories;
        this.exerciseCategoryModelMapper = exerciseCategoryModelDataMapper;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        loadExerciseCategories();
    }

    private void loadExerciseCategories() {
        getViewState().showLoading();
        getExerciseCategories.execute(new ExerciseCategoriesSubscriber());
    }

    @Override
    public void onExerciseCategoryClick(int exerciseCategoryId) {
        router.navigateTo(Screens.EXERCISES_SCREEN, exerciseCategoryId);
    }

    @Override
    protected void unsubscribe() {
        getExerciseCategories.unsubscribe();
    }


    private final class ExerciseCategoriesSubscriber extends DefaultSubscriber<List<ExerciseCategory>> {
        @Override
        public void onNext(List<ExerciseCategory> exerciseCategories) {
            getViewState().hideLoading();
            getViewState().renderExerciseCategories(
                    exerciseCategoryModelMapper.transform(exerciseCategories));
        }
    }
}
