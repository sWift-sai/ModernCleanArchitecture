package ru.swift.moderncleanarchitecture.presentation.screen.categories;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import ru.swift.moderncleanarchitecture.TestExecutionThread;
import ru.swift.moderncleanarchitecture.TestPostExecutionThread;
import ru.swift.moderncleanarchitecture.domain.interactor.GetExerciseCategories;
import ru.swift.moderncleanarchitecture.domain.model.ExerciseCategory;
import ru.swift.moderncleanarchitecture.presentation.mapper.ExerciseCategoryModelDataMapper;
import ru.swift.moderncleanarchitecture.presentation.model.ExerciseCategoryModel;
import ru.swift.moderncleanarchitecture.presentation.navigation.Screens;
import ru.swift.moderncleanarchitecture.presentation.screen.DefaultSubscriber;
import ru.terrakok.cicerone.Router;
import rx.Subscriber;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

public class ExerciseCategoriesPresenterTest {

    @Mock private Router mockRouter;
    @Mock private GetExerciseCategories mockGetExerciseCategories;
    @Mock private ExerciseCategoryModelDataMapper mockExerciseCategoryModelMapper;
    @Mock private ExerciseCategoriesContract.View mockView;
    @Mock private ExerciseCategoriesContract$View$$State mockViewState;

    private final int CATEGORY_COUNT = 2;

    // SUT
    private ExerciseCategoriesPresenter presenter;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        initPresenter();
    }

    private void initPresenter() {
        presenter = new ExerciseCategoriesPresenter(mockRouter, mockGetExerciseCategories,
                mockExerciseCategoryModelMapper);
        presenter.setViewState(mockViewState);
    }

    @Test
    public void shouldLoadAndShowCategories_onFirstViewAttach() {
        presenter.onFirstViewAttach();

        verify(mockViewState).showLoading();
        verify(mockGetExerciseCategories).execute(any(DefaultSubscriber.class));
        verifyNoMoreInteractions(mockViewState, mockGetExerciseCategories, mockRouter,
                mockExerciseCategoryModelMapper);
    }

    @Test @SuppressWarnings("unchecked")
    public void shouldRenderExerciseCategoryModels_whenResultsLoaded() {
        List<ExerciseCategory> categories = createFakeExerciseCategories();
        List<ExerciseCategoryModel> categoryModels = createFakeExerciseCategoryModels();
        given(mockExerciseCategoryModelMapper.transform(categories)).willReturn(categoryModels);
        mockGetExerciseCategories =
                new GetExerciseCategories(new TestExecutionThread(), new TestPostExecutionThread(), null) {
                    @Override
                    public void execute(Subscriber interactorSubscriber) {
                        interactorSubscriber.onNext(categories);
                    }
                };
        initPresenter();

        presenter.onFirstViewAttach();

        verify(mockViewState).hideLoading();
        verify(mockExerciseCategoryModelMapper).transform(categories);
        verify(mockViewState).renderExerciseCategories(categoryModels);
        verifyNoMoreInteractions(mockRouter, mockExerciseCategoryModelMapper);
    }

    @Test
    public void shouldNavigateToExercisesScreen_onExerciseCategoryClick() {
        int categoryId = 10;
        presenter.onExerciseCategoryClick(categoryId);

        verify(mockRouter).navigateTo(Screens.EXERCISES_SCREEN, categoryId);
        verifyNoMoreInteractions(mockViewState, mockGetExerciseCategories, mockRouter,
                mockExerciseCategoryModelMapper);
    }

    @Test
    public void shouldUnsubscribeInteractor_onDestroy() {
        presenter.onDestroy();

        verify(mockGetExerciseCategories).unsubscribe();
        verifyNoMoreInteractions(mockViewState, mockGetExerciseCategories, mockRouter,
                mockExerciseCategoryModelMapper);
    }


    private List<ExerciseCategory> createFakeExerciseCategories() {
        List<ExerciseCategory> exerciseCategories = new ArrayList<>(CATEGORY_COUNT);
        for (int i = 0; i < CATEGORY_COUNT; i++) {
            exerciseCategories.add(new ExerciseCategory());
        }

        return exerciseCategories;
    }

    private List<ExerciseCategoryModel> createFakeExerciseCategoryModels() {
        List<ExerciseCategoryModel> exerciseCategoryModels = new ArrayList<>(CATEGORY_COUNT);
        for (int i = 0; i < CATEGORY_COUNT; i++) {
            exerciseCategoryModels.add(new ExerciseCategoryModel());
        }

        return exerciseCategoryModels;
    }
}
