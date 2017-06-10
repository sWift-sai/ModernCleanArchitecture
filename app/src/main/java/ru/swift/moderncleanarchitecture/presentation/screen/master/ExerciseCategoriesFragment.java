package ru.swift.moderncleanarchitecture.presentation.screen.master;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import ru.swift.moderncleanarchitecture.ApplicationComponent;
import ru.swift.moderncleanarchitecture.ModernApplication;
import ru.swift.moderncleanarchitecture.R;
import ru.swift.moderncleanarchitecture.presentation.model.ExerciseCategoryModel;
import ru.swift.moderncleanarchitecture.presentation.screen.BaseFragment;


public class ExerciseCategoriesFragment extends BaseFragment implements ExerciseCategoriesContract.View {

    @ProvidePresenter
    public ExerciseCategoriesPresenter provideMasterPresenter() {
        ApplicationComponent appComponent = getApplicationComponent();
        return new ExerciseCategoriesPresenter(
                appComponent.provideRouter(),
                appComponent.provideGetExerciseCategories(),
                appComponent.provideExerciseCategoryModelDataMapper()
        );
    }

    @InjectPresenter
    ExerciseCategoriesPresenter presenter;

    @BindView(R.id.messageTextView) TextView messageTextView;

    private Unbinder unbinder;

    public static ExerciseCategoriesFragment newInstance() {
        return new ExerciseCategoriesFragment();
    }


    @Override
    protected void initializeInjection() {
        ModernApplication.getComponent(getActivity()).inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_exercise_categories, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void renderExerciseCategories(List<ExerciseCategoryModel> exerciseCategoryModels) {

    }
}
