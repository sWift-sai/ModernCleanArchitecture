package ru.swift.moderncleanarchitecture.presentation.screen.categories;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

    @InjectPresenter ExerciseCategoriesPresenter presenter;

    @BindView(R.id.categoriesRecyclerView) RecyclerView categoriesRecyclerView;
    @BindView(R.id.progressBar) View progressBar;
    @BindView(R.id.toolbar) Toolbar toolbar;

    private Unbinder unbinder;
    private ExerciseCategoriesAdapter categoriesAdapter;

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

        initToolbar();
        initRecyclerView();

        return view;
    }

    private void initToolbar() {
        getAppCompatActivity().setSupportActionBar(toolbar);
        getAppCompatActivity().getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setTitle(R.string.categories_title);
    }

    private void initRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        categoriesRecyclerView.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void renderExerciseCategories(List<ExerciseCategoryModel> exerciseCategoryModels) {
        categoriesAdapter = new ExerciseCategoriesAdapter(exerciseCategoryModels, getContext(), presenter);
        categoriesRecyclerView.setAdapter(categoriesAdapter);
    }
}
