package ru.swift.moderncleanarchitecture.data.remote;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import ru.swift.moderncleanarchitecture.data.remote.model.ExerciseCategoryRemote;
import ru.swift.moderncleanarchitecture.data.remote.model.ExerciseInfoRemote;
import ru.swift.moderncleanarchitecture.data.remote.model.ExerciseRemote;
import ru.swift.moderncleanarchitecture.data.remote.model.PaginatedListResponse;
import rx.Observable;

public interface ExerciseApi {

    @GET("exercisecategory")
    Observable<PaginatedListResponse<ExerciseCategoryRemote>> getExerciseCategories(@Query("page") int page);

    @GET("exercise")
    Observable<PaginatedListResponse<ExerciseRemote>> getExercisesByCategory(@Query("category") int categoryId,
                                                                             @Query("page") int page);

    @GET("exerciseinfo/{id}")
    Observable<ExerciseInfoRemote> getExerciseInfo(@Path("id") int exerciseId);

}
