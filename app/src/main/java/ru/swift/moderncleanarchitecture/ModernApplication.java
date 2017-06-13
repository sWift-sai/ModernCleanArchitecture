package ru.swift.moderncleanarchitecture;

import android.app.Application;
import android.content.Context;

import ru.swift.moderncleanarchitecture.data.remote.RemoteModule;
import ru.swift.moderncleanarchitecture.domain.DomainModule;
import ru.swift.moderncleanarchitecture.presentation.PresentationModule;
import ru.swift.moderncleanarchitecture.presentation.navigation.NavigationModule;
import timber.log.Timber;

public class ModernApplication extends Application {

    private ApplicationComponent component;

    public static ModernApplication get(Context context) {
        return (ModernApplication) context.getApplicationContext();
    }

    public static ApplicationComponent getComponent(Context context) {
        return get(context).component;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        createComponentAndInject();

        initializeLogger();
    }

    private void createComponentAndInject() {
        component = DaggerApplicationComponent.builder()
                .remoteModule(new RemoteModule())
                .domainModule(new DomainModule())
                .presentationModule(new PresentationModule())
                .navigationModule(new NavigationModule())
                .build();
        component.inject(this);
    }

    private void initializeLogger() {
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }
}
