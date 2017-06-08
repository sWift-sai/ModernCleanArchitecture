package ru.swift.moderncleanarchitecture.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.swift.moderncleanarchitecture.BuildConfig;
import ru.swift.moderncleanarchitecture.data.remote.ExerciseApi;

import static okhttp3.logging.HttpLoggingInterceptor.Level;

@Module
public class RemoteModule {

    private final String BASE_URL = "https://wger.de/api/v2";

    @Provides @Singleton
    Gson provideGson() {
        return new GsonBuilder().create();
    }

    @Provides @Singleton
    OkHttpClient provideOkHttpClient() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(BuildConfig.DEBUG ? Level.BODY : Level.NONE);

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(loggingInterceptor);
        return builder.build();
    }

    @Provides @Singleton
    Retrofit provideRetrofit(OkHttpClient client, Gson gson) {
        return new Retrofit.Builder()
                .client(client)
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    @Provides @Singleton
    ExerciseApi provideExerciseApi(Retrofit retrofit) {
        return retrofit.create(ExerciseApi.class);
    }
}
