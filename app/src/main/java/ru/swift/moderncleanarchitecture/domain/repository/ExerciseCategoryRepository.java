package ru.swift.moderncleanarchitecture.domain.repository;

import java.util.List;

import ru.swift.moderncleanarchitecture.domain.model.ExerciseCategory;
import rx.Observable;

public interface ExerciseCategoryRepository {

    Observable<List<ExerciseCategory>> getAll();

}
