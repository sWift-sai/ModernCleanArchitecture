package ru.swift.moderncleanarchitecture.domain.repository;

import java.util.List;

import ru.swift.moderncleanarchitecture.domain.model.Exercise;
import rx.Observable;

public interface ExerciseRepository {

    Observable<List<Exercise>> getAllByCategoryId(int categoryId);

}
