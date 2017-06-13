package ru.swift.moderncleanarchitecture.domain.interactor;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import ru.swift.moderncleanarchitecture.domain.scheduler.ExecutionThread;
import ru.swift.moderncleanarchitecture.domain.scheduler.PostExecutionThread;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.subscriptions.Subscriptions;

import static dagger.internal.Preconditions.checkNotNull;

public abstract class BaseInteractor<P extends BaseInteractor.Params> {

    private final ExecutionThread executionThread;
    private final PostExecutionThread postExecutionThread;

    private Subscription subscription = Subscriptions.empty();

    public BaseInteractor(@NonNull ExecutionThread executionThread,
                          @NonNull PostExecutionThread postExecutionThread) {
        this.executionThread = checkNotNull(executionThread);
        this.postExecutionThread = checkNotNull(postExecutionThread);
    }


    abstract Observable buildInteractorObservable(P params);

    @SuppressWarnings("unchecked")
    public void execute(@Nullable P params, Subscriber interactorSubscriber) {
        checkNotNull(interactorSubscriber);
        subscription = buildInteractorObservable(params)
                .subscribeOn(executionThread.getScheduler())
                .observeOn(postExecutionThread.getScheduler())
                .subscribe(interactorSubscriber);
    }

    @SuppressWarnings("unchecked")
    public void execute(Subscriber interactorSubscriber) {
        execute(null, interactorSubscriber);
    }

    public void unsubscribe() {
        if (!subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }

    public interface Params {}
}
