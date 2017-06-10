package ru.swift.moderncleanarchitecture.presentation.screen.detail;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

@InjectViewState
public class DetailPresenter extends MvpPresenter<DetailContract.View> implements DetailContract.Presenter{

    @Override
    public void onButtonClick() {
        getViewState().showMessage("Hi!");
    }
}
