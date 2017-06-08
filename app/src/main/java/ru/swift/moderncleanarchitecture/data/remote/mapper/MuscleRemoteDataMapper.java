package ru.swift.moderncleanarchitecture.data.remote.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import ru.swift.moderncleanarchitecture.data.remote.model.MuscleRemote;
import ru.swift.moderncleanarchitecture.domain.model.Muscle;

@Mapper
public interface MuscleRemoteDataMapper {

    MuscleRemoteDataMapper INSTANCE = Mappers.getMapper(MuscleRemoteDataMapper.class);

    Muscle transform(MuscleRemote muscleRemote);

}
