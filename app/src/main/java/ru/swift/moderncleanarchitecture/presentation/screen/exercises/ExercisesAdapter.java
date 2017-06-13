package ru.swift.moderncleanarchitecture.presentation.screen.exercises;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.swift.moderncleanarchitecture.R;
import ru.swift.moderncleanarchitecture.presentation.model.ExerciseModel;
import ru.swift.moderncleanarchitecture.presentation.screen.exercises.ExercisesContract.Presenter.OnExerciseClickListener;

public class ExercisesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final OnExerciseClickListener exerciseClickListener;
    private final LayoutInflater layoutInflater;
    private final List<ExerciseModel> exercises;

    public ExercisesAdapter(List<ExerciseModel> exerciseModels, Context context,
                            OnExerciseClickListener exerciseClickListener) {
        this.exerciseClickListener = exerciseClickListener;
        this.layoutInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.exercises = exerciseModels;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = this.layoutInflater.inflate(R.layout.item_exercise, parent, false);
        return new ExerciseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ExerciseViewHolder exerciseHolder = (ExerciseViewHolder) holder;
        exerciseHolder.setUp(exercises.get(position));
    }

    @Override
    public int getItemCount() {
        return exercises.size();
    }

    class ExerciseViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.exerciseName) TextView tvExerciseName;

        ExerciseViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void setUp(ExerciseModel exercise) {
            itemView.setOnClickListener(v -> {
                if (exerciseClickListener != null) {
                    exerciseClickListener.onExerciseClick(exercise.getId());
                }
            });

            tvExerciseName.setText(exercise.getName());
        }
    }

}
