package ru.swift.moderncleanarchitecture.presentation.master;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import ru.swift.moderncleanarchitecture.ModernApplication;
import ru.swift.moderncleanarchitecture.R;
import ru.swift.moderncleanarchitecture.domain.interactor.GetExerciseCategories;
import ru.terrakok.cicerone.Router;


public class MasterFragment extends MvpAppCompatFragment implements MasterContract.View {

    public static final String TAG = MasterFragment.class.getSimpleName();

    @BindView(R.id.messageTextView)
    TextView messageTextView;

    @Inject
    Router router;
    @Inject
    GetExerciseCategories getExerciseCategories;
    @InjectPresenter
    MasterPresenter presenter;

    @ProvidePresenter
    public MasterPresenter provideMasterPresenter() {
        return new MasterPresenter(router, getExerciseCategories);
    }

    private Unbinder unbinder;

    public static MasterFragment newInstance() {
        return new MasterFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        ModernApplication.get(getContext()).getApplicationComponent().inject(this);
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_master, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    @Override
    public void showMessage(String message) {
        messageTextView.setText(message);
    }

    @OnClick(R.id.openNextPageButton)
    public void onOpenNextPageButtonClick() {
        presenter.onOpenDetailClick();
    }
}
