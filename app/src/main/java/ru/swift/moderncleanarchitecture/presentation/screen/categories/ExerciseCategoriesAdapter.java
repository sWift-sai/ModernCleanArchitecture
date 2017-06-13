package ru.swift.moderncleanarchitecture.presentation.screen.categories;

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
import ru.swift.moderncleanarchitecture.presentation.model.ExerciseCategoryModel;
import ru.swift.moderncleanarchitecture.presentation.screen.categories.ExerciseCategoriesContract.Presenter.OnExerciseCategoryClickListener;
import timber.log.Timber;

public class ExerciseCategoriesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final OnExerciseCategoryClickListener categoryClickListener;
    private final LayoutInflater layoutInflater;
    private final List<ExerciseCategoryModel> categories;

    public ExerciseCategoriesAdapter(List<ExerciseCategoryModel> categories, Context context,
                                     OnExerciseCategoryClickListener categoryClickListener) {
        this.categoryClickListener = categoryClickListener;
        this.layoutInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.categories = categories;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = this.layoutInflater.inflate(R.layout.item_exercise_category, parent, false);
        return new ExerciseCategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ExerciseCategoryViewHolder categoryHolder = (ExerciseCategoryViewHolder) holder;
        categoryHolder.setUp(categories.get(position));
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    class ExerciseCategoryViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.exerciseCategoryName) TextView tvCategoryName;

        ExerciseCategoryViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void setUp(ExerciseCategoryModel category) {
            itemView.setOnClickListener(v -> {
                if (categoryClickListener != null) {
                    Timber.d("Category " + category.getId());
                    categoryClickListener.onExerciseCategoryClick(category.getId());
                }
            });

            tvCategoryName.setText(category.getName());
        }
    }

}
