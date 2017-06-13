package ru.swift.moderncleanarchitecture.presentation.screen.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.arellomobile.mvp.MvpAppCompatActivity;

import javax.inject.Inject;

import ru.swift.moderncleanarchitecture.ModernApplication;
import ru.swift.moderncleanarchitecture.R;
import ru.swift.moderncleanarchitecture.presentation.navigation.BaseNavigator;
import ru.swift.moderncleanarchitecture.presentation.navigation.Screens;
import ru.swift.moderncleanarchitecture.presentation.screen.exercises.ExercisesFragment;
import ru.swift.moderncleanarchitecture.presentation.screen.categories.ExerciseCategoriesFragment;
import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.commands.Replace;

public class MainActivity extends MvpAppCompatActivity {

    @Inject
    NavigatorHolder navigatorHolder;

    private Navigator navigator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ModernApplication.getComponent(this).inject(this);
        super.onCreate(savedInstanceState);
        prepareNavigator();

        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            navigator.applyCommand(new Replace(Screens.EXERCISE_CATEGORIES_SCREEN, null));
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
                    case Screens.EXERCISES_SCREEN:
                        return ExercisesFragment.newInstance((int) data);

                    case Screens.EXERCISE_CATEGORIES_SCREEN:
                    default:
                        return ExerciseCategoriesFragment.newInstance();
                }
            }

            @Override
            protected void exit() {
                finish();
            }
        };
    }
}
