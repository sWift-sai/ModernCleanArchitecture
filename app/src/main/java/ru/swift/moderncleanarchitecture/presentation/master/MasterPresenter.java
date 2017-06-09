package ru.swift.moderncleanarchitecture.presentation.master;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.List;

import ru.swift.moderncleanarchitecture.domain.interactor.GetExerciseCategories;
import ru.swift.moderncleanarchitecture.domain.model.ExerciseCategory;
import ru.swift.moderncleanarchitecture.presentation.navigation.Screens;
import ru.terrakok.cicerone.Router;
import rx.Subscriber;

@InjectViewState
public class MasterPresenter extends MvpPresenter<MasterContract.View> implements MasterContract.Presenter {

    private final Router router;
    private GetExerciseCategories getExerciseCategories;

    // FIXME it's temporary
    public MasterPresenter(Router router, GetExerciseCategories getExerciseCategories) {
        this.router = router;
        this.getExerciseCategories = getExerciseCategories;
    }

    @Override
    public void onOpenDetailClick() {
        router.navigateTo(Screens.DETAIL_SCREEN);
        getExerciseCategories.execute(null, new Subscriber<List<ExerciseCategory>>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
                Log.d("MASTER", "ERROR: " + e);
            }

            @Override
            public void onNext(List<ExerciseCategory> exerciseCategories) {
                Log.d("MASTER", "Exercise categories: " + exerciseCategories);
            }
        });
    }
}
