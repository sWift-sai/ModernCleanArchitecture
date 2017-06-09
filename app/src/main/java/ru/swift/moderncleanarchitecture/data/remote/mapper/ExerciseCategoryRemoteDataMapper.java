package ru.swift.moderncleanarchitecture.data.remote.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

import ru.swift.moderncleanarchitecture.data.remote.model.ExerciseCategoryRemote;
import ru.swift.moderncleanarchitecture.domain.model.ExerciseCategory;

@Mapper
public interface ExerciseCategoryRemoteDataMapper {

    ExerciseCategoryRemoteDataMapper INSTANCE = Mappers.getMapper(ExerciseCategoryRemoteDataMapper.class);


    ExerciseCategory transform(ExerciseCategoryRemote exerciseCategoryRemote);

    List<ExerciseCategory> transform(List<ExerciseCategoryRemote> exerciseCategoryRemoteList);
}
