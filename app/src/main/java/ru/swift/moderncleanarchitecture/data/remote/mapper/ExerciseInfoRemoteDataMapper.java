package ru.swift.moderncleanarchitecture.data.remote.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import ru.swift.moderncleanarchitecture.data.remote.model.ExerciseInfoRemote;
import ru.swift.moderncleanarchitecture.domain.model.ExerciseInfo;

@Mapper(uses = {
        ExerciseCategoryRemoteDataMapper.class,
        MuscleRemoteDataMapper.class,
        EquipmentRemoteDataMapper.class
})
public interface ExerciseInfoRemoteDataMapper {

    ExerciseInfoRemoteDataMapper INSTANCE = Mappers.getMapper(ExerciseInfoRemoteDataMapper.class);

    ExerciseInfo transform(ExerciseInfoRemote exerciseInfoRemote);
}
