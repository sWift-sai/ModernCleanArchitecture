package ru.swift.moderncleanarchitecture.presentation.screen;

import com.arellomobile.mvp.MvpPresenter;
import com.arellomobile.mvp.MvpView;

public abstract class BasePresenter<View extends MvpView> extends MvpPresenter<View> {

    @Override
    public void onDestroy() {
        unsubscribe();
        super.onDestroy();
    }

    /**
     *  Unsubscribe all interactors here
     */
    protected abstract void unsubscribe();
}
