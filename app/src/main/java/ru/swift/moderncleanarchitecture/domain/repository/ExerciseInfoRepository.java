package ru.swift.moderncleanarchitecture.domain.repository;

import ru.swift.moderncleanarchitecture.domain.model.ExerciseInfo;
import rx.Observable;

public interface ExerciseInfoRepository {

    Observable<ExerciseInfo> getByExerciseId(int exerciseId);

}
