package ru.swift.moderncleanarchitecture.presentation.screen.exercises;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import ru.swift.moderncleanarchitecture.TestExecutionThread;
import ru.swift.moderncleanarchitecture.TestPostExecutionThread;
import ru.swift.moderncleanarchitecture.domain.interactor.GetExercises;
import ru.swift.moderncleanarchitecture.domain.model.Exercise;
import ru.swift.moderncleanarchitecture.presentation.mapper.ExerciseModelDataMapper;
import ru.swift.moderncleanarchitecture.presentation.model.ExerciseModel;
import ru.swift.moderncleanarchitecture.presentation.navigation.Screens;
import ru.swift.moderncleanarchitecture.presentation.screen.DefaultSubscriber;
import ru.terrakok.cicerone.Router;
import rx.Subscriber;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

public class ExercisesPresenterTest {

    @Mock private Router mockRouter;
    @Mock private GetExercises mockGetExercises;
    @Mock private ExerciseModelDataMapper mockExerciseModelMapper;
    @Mock private ExercisesContract$View$$State mockViewState;

    private final int EXERCISE_COUNT = 2;
    private final int EXERCISE_CATEGORY_ID = 10;

    // SUT
    private ExercisesPresenter presenter;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        initPresenter();
    }

    private void initPresenter() {
        presenter = new ExercisesPresenter(mockRouter, mockGetExercises, mockExerciseModelMapper,
                EXERCISE_CATEGORY_ID);
        presenter.setViewState(mockViewState);
    }

    @Test
    public void shouldLoadAndShowExercises_onFirstViewAttach() {
        GetExercises.Params params = new GetExercises.Params(EXERCISE_CATEGORY_ID);
        presenter.onFirstViewAttach();

        verify(mockViewState).showLoading();
        verify(mockGetExercises).execute(eq(params), any(DefaultSubscriber.class));
        verifyNoMoreInteractions(mockViewState, mockGetExercises, mockRouter, mockExerciseModelMapper);
    }

    @Test @SuppressWarnings("unchecked")
    public void shouldRenderExerciseModels_whenResultsLoaded() {
        List<Exercise> exercises = createFakeExercises();
        List<ExerciseModel> exerciseModels = createFakeExerciseModels();
        given(mockExerciseModelMapper.transform(exercises)).willReturn(exerciseModels);
        mockGetExercises =
                new GetExercises(new TestExecutionThread(), new TestPostExecutionThread(), null) {
                    @Override
                    public void execute(Params params, Subscriber interactorSubscriber) {
                        interactorSubscriber.onNext(exercises);
                    }
                };
        initPresenter();

        presenter.onFirstViewAttach();

        verify(mockViewState).hideLoading();
        verify(mockExerciseModelMapper).transform(exercises);
        verify(mockViewState).renderExercises(exerciseModels);
        verifyNoMoreInteractions(mockRouter, mockExerciseModelMapper);
    }

    @Test
    public void shouldNavigateToExerciseInfoScreen_onExerciseClick() {
        int exerciseId = 15;
        presenter.onExerciseClick(exerciseId);

        verify(mockRouter).navigateTo(Screens.EXERCISE_INFO_SCREEN, exerciseId);
        verifyNoMoreInteractions(mockViewState, mockGetExercises, mockRouter, mockExerciseModelMapper);
    }

        @Test
    public void shouldExitFromScreen_onBackPressed() {
        presenter.onBackPressed();

        verify(mockRouter).exit();
        verifyNoMoreInteractions(mockViewState, mockGetExercises, mockRouter, mockExerciseModelMapper);
    }

    @Test
    public void shouldUnsubscribeInteractor_onDestroy() {
        presenter.onDestroy();

        verify(mockGetExercises).unsubscribe();
        verifyNoMoreInteractions(mockViewState, mockGetExercises, mockRouter, mockExerciseModelMapper);
    }


    private List<Exercise> createFakeExercises() {
        List<Exercise> exercises = new ArrayList<>(EXERCISE_COUNT);
        for (int i = 0; i < EXERCISE_COUNT; i++) {
            exercises.add(new Exercise());
        }

        return exercises;
    }

    private List<ExerciseModel> createFakeExerciseModels() {
        List<ExerciseModel> exerciseModels = new ArrayList<>(EXERCISE_COUNT);
        for (int i = 0; i < EXERCISE_COUNT; i++) {
            exerciseModels.add(new ExerciseModel());
        }

        return exerciseModels;
    }

}
