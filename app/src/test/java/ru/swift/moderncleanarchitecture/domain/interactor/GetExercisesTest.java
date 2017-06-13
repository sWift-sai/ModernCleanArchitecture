package ru.swift.moderncleanarchitecture.domain.interactor;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import ru.swift.moderncleanarchitecture.domain.model.Exercise;
import ru.swift.moderncleanarchitecture.domain.repository.ExerciseRepository;
import ru.swift.moderncleanarchitecture.domain.scheduler.ExecutionThread;
import ru.swift.moderncleanarchitecture.domain.scheduler.PostExecutionThread;
import rx.Observable;
import rx.observers.TestSubscriber;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;

public class GetExercisesTest {

    private static final int CATEGORY_ID = 10;

    @Mock private ExecutionThread mockExecutionThread;
    @Mock private PostExecutionThread mockPostExecutionThread;
    @Mock private ExerciseRepository mockExerciseRepository;

    // SUT
    private GetExercises getExercises;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        getExercises = new GetExercises(
                mockExecutionThread,
                mockPostExecutionThread,
                mockExerciseRepository
        );
    }

    @Test @SuppressWarnings("unchecked")
    public void shouldGetCorrectResult() {
        doReturn(Observable.just(new ArrayList<>()))
                .when(mockExerciseRepository).getAllByCategoryId(CATEGORY_ID);

        Observable<List<Exercise>> result =
                getExercises.buildInteractorObservable(new GetExercises.Params(CATEGORY_ID));

        TestSubscriber<List<Exercise>> testSubscriber = new TestSubscriber<>();
        result.subscribe(testSubscriber);
        testSubscriber.assertNoErrors();
        testSubscriber.assertCompleted();
        testSubscriber.assertValueCount(1);
    }

    @Test
    public void shouldCallRepositoryOnce() {
        getExercises.buildInteractorObservable(new GetExercises.Params(CATEGORY_ID));

        verify(mockExerciseRepository).getAllByCategoryId(CATEGORY_ID);
        verifyNoMoreInteractions(mockExerciseRepository);
        verifyZeroInteractions(mockExecutionThread);
        verifyZeroInteractions(mockPostExecutionThread);
    }
}
