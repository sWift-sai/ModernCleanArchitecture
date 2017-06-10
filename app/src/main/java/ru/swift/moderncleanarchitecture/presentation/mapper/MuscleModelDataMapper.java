package ru.swift.moderncleanarchitecture.presentation.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import ru.swift.moderncleanarchitecture.domain.model.Muscle;
import ru.swift.moderncleanarchitecture.presentation.model.MuscleModel;

@Mapper
public interface MuscleModelDataMapper {

    MuscleModelDataMapper INSTANCE = Mappers.getMapper(MuscleModelDataMapper.class);

    MuscleModel transform(Muscle muscle);

}
