package ru.swift.moderncleanarchitecture.presentation.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

import ru.swift.moderncleanarchitecture.domain.model.ExerciseCategory;
import ru.swift.moderncleanarchitecture.presentation.model.ExerciseCategoryModel;

@Mapper
public interface ExerciseCategoryModelDataMapper {

    ExerciseCategoryModelDataMapper INSTANCE = Mappers.getMapper(ExerciseCategoryModelDataMapper.class);


    ExerciseCategoryModel transform(ExerciseCategory exerciseCategory);

    List<ExerciseCategoryModel> transform(List<ExerciseCategory> exerciseCategoryList);
}
