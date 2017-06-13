package ru.swift.moderncleanarchitecture.domain.interactor;

import lombok.EqualsAndHashCode;
import ru.swift.moderncleanarchitecture.domain.repository.ExerciseRepository;
import ru.swift.moderncleanarchitecture.domain.scheduler.ExecutionThread;
import ru.swift.moderncleanarchitecture.domain.scheduler.PostExecutionThread;
import rx.Observable;

public class GetExercises extends BaseInteractor<GetExercises.Params> {

    private final ExerciseRepository exerciseRepository;

    public GetExercises(ExecutionThread executionThread,
                        PostExecutionThread postExecutionThread,
                        ExerciseRepository exerciseRepository) {
        super(executionThread, postExecutionThread);
        this.exerciseRepository = exerciseRepository;
    }

    @Override
    protected Observable buildInteractorObservable(Params params) {
        return exerciseRepository.getAllByCategoryId(params.getCategoryId());
    }

    @EqualsAndHashCode
    public static final class Params implements BaseInteractor.Params {

        private final int categoryId;

        public Params(int categoryId) {
            this.categoryId = categoryId;
        }

        public int getCategoryId() {
            return categoryId;
        }
    }
}
