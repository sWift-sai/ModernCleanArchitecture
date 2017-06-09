package ru.swift.moderncleanarchitecture.domain.interactor;

import android.support.annotation.NonNull;

import ru.swift.moderncleanarchitecture.domain.scheduler.ExecutionThread;
import ru.swift.moderncleanarchitecture.domain.scheduler.PostExecutionThread;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.subscriptions.Subscriptions;

import static dagger.internal.Preconditions.checkNotNull;

public abstract class BaseInteractor<P extends BaseInteractor.RequestParams> {

    private final ExecutionThread executionThread;
    private final PostExecutionThread postExecutionThread;

    private Subscription subscription = Subscriptions.empty();

    public BaseInteractor(@NonNull ExecutionThread executionThread,
                          @NonNull PostExecutionThread postExecutionThread) {
        this.executionThread = checkNotNull(executionThread);
        this.postExecutionThread = checkNotNull(postExecutionThread);
    }


    protected abstract Observable buildInteractorObservable(P params);

    @SuppressWarnings("unchecked")
    public void execute(P params, Subscriber interactorSubscriber) {
        subscription = buildInteractorObservable(params)
                .subscribeOn(executionThread.getScheduler())
                .observeOn(postExecutionThread.getScheduler())
                .subscribe(interactorSubscriber);
    }

    public void unsubscribe() {
        if (!subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }

    public interface RequestParams {}
}
