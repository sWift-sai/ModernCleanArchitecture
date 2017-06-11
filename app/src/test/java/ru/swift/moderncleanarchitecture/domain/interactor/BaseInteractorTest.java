package ru.swift.moderncleanarchitecture.domain.interactor;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import ru.swift.moderncleanarchitecture.domain.scheduler.ExecutionThread;
import ru.swift.moderncleanarchitecture.domain.scheduler.PostExecutionThread;
import rx.Observable;
import rx.observers.TestSubscriber;
import rx.schedulers.TestScheduler;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

public class BaseInteractorTest {

    @Rule public ExpectedException expectedException = ExpectedException.none();

    @Mock private ExecutionThread mockExecutionThread;
    @Mock private PostExecutionThread mockPostExecutionThread;
    private TestSubscriber<Integer> testSubscriber;

    // SUT
    private BaseInteractorTestClass interactor;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        interactor = new BaseInteractorTestClass(mockExecutionThread, mockPostExecutionThread);
        testSubscriber = new TestSubscriber<>();
    }

    @Test
    @SuppressWarnings("unchecked")
    public void shouldReturnCorrectResult_whenExecuteWithRequestParams() {
        TestScheduler testScheduler = new TestScheduler();
        given(mockPostExecutionThread.getScheduler()).willReturn(testScheduler);

        interactor.execute(BaseInteractorTestClass.Params.EMPTY, testSubscriber);

        assertThat(testSubscriber.getOnNextEvents().size()).isEqualTo(0);
    }

    @Test
    @SuppressWarnings("unchecked")
    public void shouldReturnCorrectResult_whenExecute() {
        TestScheduler testScheduler = new TestScheduler();
        given(mockPostExecutionThread.getScheduler()).willReturn(testScheduler);

        interactor.execute(testSubscriber);

        assertThat(testSubscriber.getOnNextEvents().size()).isEqualTo(0);
    }

    @Test
    public void shouldUnsubscribe_whenUnsubscribeAfterExecution() {
        interactor.execute(testSubscriber);
        interactor.unsubscribe();

        assertThat(testSubscriber.isUnsubscribed()).isTrue();
    }

    @Test
    public void shouldThrowNullPointerException_whenExecuteWithNullSubscriber() {
        expectedException.expect(NullPointerException.class);

        interactor.execute(null);
    }

    @Test
    public void shouldThrowNullPointerException_whenInitWithNullExecutionThread() {
        expectedException.expect(NullPointerException.class);

        interactor = new BaseInteractorTestClass(null, mockPostExecutionThread);
    }

    @Test
    public void shouldThrowNullPointerException_whenInitWithNullPostExecutionThread() {
        expectedException.expect(NullPointerException.class);

        interactor = new BaseInteractorTestClass(mockExecutionThread, null);
    }


    private static class BaseInteractorTestClass extends BaseInteractor<BaseInteractorTestClass.Params> {

        BaseInteractorTestClass(ExecutionThread executionThread,
                                PostExecutionThread postExecutionThread) {
            super(executionThread, postExecutionThread);
        }

        @Override
        protected Observable buildInteractorObservable(Params params) {
            return Observable.empty();
        }

        static class Params implements BaseInteractor.Params {
            private final static Params EMPTY = new Params();
        }
    }

}
