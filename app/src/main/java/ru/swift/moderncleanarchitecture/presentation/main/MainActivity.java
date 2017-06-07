package ru.swift.moderncleanarchitecture.presentation.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.arellomobile.mvp.MvpAppCompatActivity;

import javax.inject.Inject;

import ru.swift.moderncleanarchitecture.ModernApplication;
import ru.swift.moderncleanarchitecture.R;
import ru.swift.moderncleanarchitecture.presentation.navigation.BaseNavigator;
import ru.swift.moderncleanarchitecture.presentation.navigation.Screens;
import ru.swift.moderncleanarchitecture.presentation.detail.DetailFragment;
import ru.swift.moderncleanarchitecture.presentation.master.MasterFragment;
import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.commands.Replace;

public class MainActivity extends MvpAppCompatActivity {

    @Inject
    NavigatorHolder navigatorHolder;

    private Navigator navigator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ModernApplication.get(this).getApplicationComponent().inject(this);
        super.onCreate(savedInstanceState);
        prepareNavigator();

        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            navigator.applyCommand(new Replace(Screens.MASTER_SCREEN, null));
        }
    }

    @Override
    protected void onResumeFragments() {
        super.onResumeFragments();
        navigatorHolder.setNavigator(navigator);
    }

    @Override
    protected void onPause() {
        navigatorHolder.removeNavigator();
        super.onPause();
    }

    private void prepareNavigator() {
        navigator = new BaseNavigator(getSupportFragmentManager(), R.id.fragment_container) {
            @Override
            protected Fragment createFragment(String screenKey, Object data) {
                switch (screenKey) {
                    case Screens.DETAIL_SCREEN:
                        return DetailFragment.newInstance();

                    case Screens.MASTER_SCREEN:
                    default:
                        return MasterFragment.newInstance();
                }
            }

            @Override
            protected void exit() {
                finish();
            }
        };
    }
}
