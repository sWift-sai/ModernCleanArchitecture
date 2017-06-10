package ru.swift.moderncleanarchitecture.presentation.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import ru.swift.moderncleanarchitecture.domain.model.Exercise;
import ru.swift.moderncleanarchitecture.presentation.model.ExerciseModel;

@Mapper
public interface ExerciseModelDataMapper {

    ExerciseModelDataMapper INSTANCE = Mappers.getMapper(ExerciseModelDataMapper.class);

    ExerciseModel transform(Exercise exercise);
}
