package ru.swift.moderncleanarchitecture.domain.interactor;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import ru.swift.moderncleanarchitecture.domain.model.ExerciseCategory;
import ru.swift.moderncleanarchitecture.domain.repository.ExerciseCategoryRepository;
import ru.swift.moderncleanarchitecture.domain.scheduler.ExecutionThread;
import ru.swift.moderncleanarchitecture.domain.scheduler.PostExecutionThread;
import rx.Observable;
import rx.observers.TestSubscriber;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;

public class GetExerciseCategoriesTest {

    @Mock private ExecutionThread mockExecutionThread;
    @Mock private PostExecutionThread mockPostExecutionThread;
    @Mock private ExerciseCategoryRepository mockExerciseCategoryRepository;

    // SUT
    private GetExerciseCategories getExerciseCategories;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        getExerciseCategories = new GetExerciseCategories(
                mockExecutionThread,
                mockPostExecutionThread,
                mockExerciseCategoryRepository
        );
    }

    @Test @SuppressWarnings("unchecked")
    public void shouldGetCorrectResult() {
        doReturn(Observable.just(new ArrayList<>()))
                .when(mockExerciseCategoryRepository).getAll();

        Observable<List<ExerciseCategory>> result = getExerciseCategories.buildInteractorObservable(null);

        TestSubscriber<List<ExerciseCategory>> testSubscriber = new TestSubscriber<>();
        result.subscribe(testSubscriber);
        testSubscriber.assertNoErrors();
        testSubscriber.assertCompleted();
        testSubscriber.assertValueCount(1);
    }

    @Test
    public void shouldCallRepositoryOnce() {
        getExerciseCategories.buildInteractorObservable(null);

        verify(mockExerciseCategoryRepository).getAll();
        verifyNoMoreInteractions(mockExerciseCategoryRepository);
        verifyZeroInteractions(mockExecutionThread);
        verifyZeroInteractions(mockPostExecutionThread);
    }
}
