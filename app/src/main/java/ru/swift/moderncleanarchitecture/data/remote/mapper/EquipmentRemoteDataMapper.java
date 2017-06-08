package ru.swift.moderncleanarchitecture.data.remote.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import ru.swift.moderncleanarchitecture.data.remote.model.EquipmentRemote;
import ru.swift.moderncleanarchitecture.domain.model.Equipment;

@Mapper
public interface EquipmentRemoteDataMapper {

    EquipmentRemoteDataMapper INSTANCE = Mappers.getMapper(EquipmentRemoteDataMapper.class);

    Equipment transform(EquipmentRemote equipmentRemote);
}
