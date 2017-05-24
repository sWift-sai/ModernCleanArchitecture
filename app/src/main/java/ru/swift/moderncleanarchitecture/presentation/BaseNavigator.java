package ru.swift.moderncleanarchitecture.presentation;

import android.support.v4.app.FragmentManager;

import ru.terrakok.cicerone.android.SupportFragmentNavigator;

abstract class BaseNavigator extends SupportFragmentNavigator {

    BaseNavigator(FragmentManager fragmentManager, int containerId) {
        super(fragmentManager, containerId);
    }

    @Override
    protected void showSystemMessage(String s) {
        // nothing to do
    }
}
