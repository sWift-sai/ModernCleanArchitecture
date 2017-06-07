package ru.swift.moderncleanarchitecture;

import android.app.Application;
import android.content.Context;

import ru.swift.moderncleanarchitecture.data.DataModule;
import ru.swift.moderncleanarchitecture.domain.DomainModule;
import ru.swift.moderncleanarchitecture.presentation.navigation.NavigationModule;
import ru.swift.moderncleanarchitecture.presentation.PresentationModule;

public class ModernApplication extends Application {

    private ApplicationComponent component;

    public static ModernApplication get(Context context) {
        return (ModernApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        createComponentAndInject();
    }

    private void createComponentAndInject() {
        component = DaggerApplicationComponent.builder()
                .dataModule(new DataModule())
                .domainModule(new DomainModule())
                .presentationModule(new PresentationModule())
                .navigationModule(new NavigationModule())
                .build();
        component.inject(this);
    }

    public ApplicationComponent getApplicationComponent(){
        return component;
    }
}
