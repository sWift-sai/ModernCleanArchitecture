/*
 * Copyright (c) 2016 Mediteo GmbH.
 */

package ru.swift.moderncleanarchitecture.presentation.screen;

import com.arellomobile.mvp.MvpView;

/**
 * Interface representing a View that will use to load data.
 */
public interface LoadDataView extends MvpView {

    void showLoading();

    void hideLoading();

}