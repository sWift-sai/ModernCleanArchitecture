package ru.swift.moderncleanarchitecture.data.remote;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import ru.swift.moderncleanarchitecture.data.remote.model.Exercise;
import ru.swift.moderncleanarchitecture.data.remote.model.ExerciseCategory;
import ru.swift.moderncleanarchitecture.data.remote.model.ExerciseInfo;
import rx.Observable;

public interface ExerciseApi {

    @GET("exercisecategory")
    Observable<List<ExerciseCategory>> getExerciseCategories();

    @GET("exercise")
    Observable<List<Exercise>> getExercisesForCategory(@Query("category") int categoryId);

    @GET("exerciseinfo/{id}")
    Observable<ExerciseInfo> getExerciseInfo(@Path("id") int exerciseId);

}
