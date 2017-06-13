package ru.swift.moderncleanarchitecture.data.remote.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

import ru.swift.moderncleanarchitecture.data.remote.model.ExerciseRemote;
import ru.swift.moderncleanarchitecture.domain.model.Exercise;

@Mapper
public interface ExerciseRemoteDataMapper {

    ExerciseRemoteDataMapper INSTANCE = Mappers.getMapper(ExerciseRemoteDataMapper.class);

    Exercise transform(ExerciseRemote exerciseRemote);

    List<Exercise> transform(List<ExerciseRemote> exerciseRemoteList);
}
