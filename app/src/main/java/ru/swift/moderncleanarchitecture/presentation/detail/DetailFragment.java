package ru.swift.moderncleanarchitecture.presentation.detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import ru.swift.moderncleanarchitecture.ModernApplication;
import ru.swift.moderncleanarchitecture.R;


public class DetailFragment extends MvpAppCompatFragment implements DetailContract.View {

    public static final String TAG = DetailFragment.class.getSimpleName();

    @InjectPresenter
    DetailPresenter presenter;

    @BindView(R.id.messageTextView)
    TextView messageTextView;

    private Unbinder unbinder;

    public static DetailFragment newInstance() {
        return new DetailFragment();
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
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
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

    @OnClick(R.id.showMessageButton)
    public void onShowMessageButtonClick() {
        presenter.onButtonClick();
    }
}
