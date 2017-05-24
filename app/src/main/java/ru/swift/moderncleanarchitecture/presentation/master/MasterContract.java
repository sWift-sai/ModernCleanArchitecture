package ru.swift.moderncleanarchitecture.presentation.master;

import com.arellomobile.mvp.MvpView;

interface MasterContract {

    interface View extends MvpView {
        void showMessage(String message);
    }

    interface Presenter {
        void onOpenDetailClick();
    }
}
