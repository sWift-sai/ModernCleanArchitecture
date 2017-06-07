package ru.swift.moderncleanarchitecture;

import javax.inject.Singleton;

import dagger.Component;
import ru.swift.moderncleanarchitecture.data.DataModule;
import ru.swift.moderncleanarchitecture.domain.DomainModule;
import ru.swift.moderncleanarchitecture.presentation.main.MainActivity;
import ru.swift.moderncleanarchitecture.presentation.navigation.NavigationModule;
import ru.swift.moderncleanarchitecture.presentation.PresentationModule;
import ru.swift.moderncleanarchitecture.presentation.detail.DetailFragment;
import ru.swift.moderncleanarchitecture.presentation.master.MasterFragment;

@Singleton
@Component(modules = {
        DataModule.class,
        DomainModule.class,
        PresentationModule.class,
        NavigationModule.class
})
public interface ApplicationComponent {

    void inject(ModernApplication application);

    void inject(MainActivity activity);

    void inject(MasterFragment masterFragment);

    void inject(DetailFragment detailFragment);
}
