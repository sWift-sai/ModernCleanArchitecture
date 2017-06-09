package ru.swift.moderncleanarchitecture.domain.interactor;

import ru.swift.moderncleanarchitecture.domain.scheduler.ExecutionThread;
import ru.swift.moderncleanarchitecture.domain.scheduler.PostExecutionThread;
import ru.swift.moderncleanarchitecture.domain.repository.ExerciseCategoryRepository;
import rx.Observable;

public class GetExerciseCategories extends BaseInteractor<BaseInteractor.RequestParams> {

    private final ExerciseCategoryRepository exerciseCategoryRepository;

    public GetExerciseCategories(ExecutionThread executionThread,
                                 PostExecutionThread postExecutionThread,
                                 ExerciseCategoryRepository exerciseCategoryRepository) {
        super(executionThread, postExecutionThread);
        this.exerciseCategoryRepository = exerciseCategoryRepository;
    }

    @Override
    protected Observable buildInteractorObservable(RequestParams params) {
        return exerciseCategoryRepository.getAll();
    }
}
