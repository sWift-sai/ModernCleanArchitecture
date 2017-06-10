package ru.swift.moderncleanarchitecture.presentation.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import ru.swift.moderncleanarchitecture.domain.model.ExerciseInfo;
import ru.swift.moderncleanarchitecture.presentation.model.ExerciseInfoModel;

@Mapper(uses = {
        ExerciseCategoryModelDataMapper.class,
        MuscleModelDataMapper.class,
        EquipmentModelDataMapper.class
})
public interface ExerciseInfoModelDataMapper {

    ExerciseInfoModelDataMapper INSTANCE = Mappers.getMapper(ExerciseInfoModelDataMapper.class);

    ExerciseInfoModel transform(ExerciseInfo exerciseInfo);
}
