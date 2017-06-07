package ru.swift.moderncleanarchitecture.presentation.navigation;

import android.support.v4.app.FragmentManager;

import ru.terrakok.cicerone.android.SupportFragmentNavigator;

public abstract class BaseNavigator extends SupportFragmentNavigator {

    public BaseNavigator(FragmentManager fragmentManager, int containerId) {
        super(fragmentManager, containerId);
    }

    @Override
    protected void showSystemMessage(String s) {
        // nothing to do
    }
}
