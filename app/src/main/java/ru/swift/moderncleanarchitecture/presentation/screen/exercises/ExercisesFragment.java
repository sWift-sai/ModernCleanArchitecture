package ru.swift.moderncleanarchitecture.presentation.screen.exercises;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
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
import ru.swift.moderncleanarchitecture.presentation.model.ExerciseModel;
import ru.swift.moderncleanarchitecture.presentation.screen.BackButtonListener;
import ru.swift.moderncleanarchitecture.presentation.screen.BaseFragment;


public class ExercisesFragment extends BaseFragment implements ExercisesContract.View,
        BackButtonListener {

    public static final String KEY_EXERCISE_CATEGORY_ID = "exercise category id";

    @ProvidePresenter
    public ExercisesPresenter provideExercisesPresenter() {
        int exerciseCategoryId = getArguments().getInt(KEY_EXERCISE_CATEGORY_ID);
        ApplicationComponent appComponent = getApplicationComponent();

        return new ExercisesPresenter(
                appComponent.provideRouter(),
                appComponent.provideGetExercises(),
                appComponent.provideExerciseModelDataMapper(),
                exerciseCategoryId
        );
    }

    @InjectPresenter ExercisesPresenter presenter;

    @BindView(R.id.exercisesRecyclerView) RecyclerView exercisesRecyclerView;
    @BindView(R.id.progressBar) View progressBar;
    @BindView(R.id.toolbar) Toolbar toolbar;

    private Unbinder unbinder;
    private ExercisesAdapter exercisesAdapter;

    public static ExercisesFragment newInstance(int exerciseCategoryId) {
        ExercisesFragment exercisesFragment = new ExercisesFragment();

        Bundle args = new Bundle();
        args.putInt(KEY_EXERCISE_CATEGORY_ID, exerciseCategoryId);
        exercisesFragment.setArguments(args);

        return exercisesFragment;
    }


    @Override
    protected void initializeInjection() {
        ModernApplication.getComponent(getActivity()).inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_exercises, container, false);
        unbinder = ButterKnife.bind(this, view);

        initToolbar();
        initRecyclerView();

        return view;
    }

    private void initToolbar() {
        getAppCompatActivity().setSupportActionBar(toolbar);
        ActionBar actionBar = getAppCompatActivity().getSupportActionBar();

        actionBar.setDisplayShowTitleEnabled(false);
        toolbar.setTitle(R.string.exercises_title);

        // back button
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(v -> presenter.onBackPressed());
    }

    private void initRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        exercisesRecyclerView.setLayoutManager(linearLayoutManager);
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
    public void renderExercises(List<ExerciseModel> exerciseModels) {
        exercisesAdapter = new ExercisesAdapter(exerciseModels, getContext(), presenter);
        exercisesRecyclerView.setAdapter(exercisesAdapter);
    }

    @Override
    public boolean onBackPressed() {
        presenter.onBackPressed();
        return true;
    }
}
