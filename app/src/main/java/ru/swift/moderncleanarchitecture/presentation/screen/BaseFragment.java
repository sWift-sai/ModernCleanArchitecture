package ru.swift.moderncleanarchitecture.presentation.screen;

import android.os.Bundle;

import com.arellomobile.mvp.MvpAppCompatFragment;

import ru.swift.moderncleanarchitecture.ApplicationComponent;
import ru.swift.moderncleanarchitecture.ModernApplication;


public abstract class BaseFragment extends MvpAppCompatFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        initializeInjection();
        super.onCreate(savedInstanceState);
    }

    protected ApplicationComponent getApplicationComponent() {
        return ModernApplication.getComponent(getActivity());
    }

    protected abstract void initializeInjection();

}
