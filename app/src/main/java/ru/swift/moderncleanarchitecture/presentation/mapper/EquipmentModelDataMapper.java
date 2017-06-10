package ru.swift.moderncleanarchitecture.presentation.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import ru.swift.moderncleanarchitecture.domain.model.Equipment;
import ru.swift.moderncleanarchitecture.presentation.model.EquipmentModel;

@Mapper
public interface EquipmentModelDataMapper {

    EquipmentModelDataMapper INSTANCE = Mappers.getMapper(EquipmentModelDataMapper.class);

    EquipmentModel transform(Equipment equipment);
}
