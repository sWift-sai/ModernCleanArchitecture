package ru.swift.moderncleanarchitecture.data.remote.mapper;

import org.junit.Before;
import org.junit.Test;

import ru.swift.moderncleanarchitecture.data.remote.model.EquipmentRemote;
import ru.swift.moderncleanarchitecture.domain.model.Equipment;

import static org.assertj.core.api.Assertions.assertThat;

public class EquipmentRemoteDataMapperTest {

    private static final int EXPECTED_ID = 12;
    private static final String EXPECTED_NAME = "name";

    // SUT
    private EquipmentRemoteDataMapper mapper;

    @Before
    public void setUp() {
        mapper = EquipmentRemoteDataMapper.INSTANCE;
    }

    @Test
    public void shouldTransformFromEquipmentRemoteToEquipment() {
        Equipment actual = mapper.transform(createFakeEquipmentRemote());

        assertThat(actual.getId()).isEqualTo(EXPECTED_ID);
        assertThat(actual.getName()).isEqualTo(EXPECTED_NAME);
    }

    private EquipmentRemote createFakeEquipmentRemote() {
        EquipmentRemote equipmentRemote = new EquipmentRemote();
        equipmentRemote.setId(EXPECTED_ID);
        equipmentRemote.setName(EXPECTED_NAME);
        return equipmentRemote;
    }

}
