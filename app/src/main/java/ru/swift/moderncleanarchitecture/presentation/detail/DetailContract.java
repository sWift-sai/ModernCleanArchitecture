package ru.swift.moderncleanarchitecture.presentation.detail;

import com.arellomobile.mvp.MvpView;

interface DetailContract {

    interface View extends MvpView {
        void showMessage(String message);
    }

    interface Presenter {
        void onButtonClick();
    }
}
