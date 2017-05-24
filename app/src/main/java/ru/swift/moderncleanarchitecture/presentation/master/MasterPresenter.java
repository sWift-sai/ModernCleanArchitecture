package ru.swift.moderncleanarchitecture.presentation.master;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import ru.swift.moderncleanarchitecture.presentation.Screens;
import ru.terrakok.cicerone.Router;

@InjectViewState
public class MasterPresenter extends MvpPresenter<MasterContract.View> implements MasterContract.Presenter {

    private final Router router;

    public MasterPresenter(Router router) {
        this.router = router;
    }

    @Override
    public void onOpenDetailClick() {
        router.navigateTo(Screens.DETAIL_SCREEN);
    }
}
