package ru.swift.moderncleanarchitecture.data.remote.mapper;

import org.junit.Before;
import org.junit.Test;

import ru.swift.moderncleanarchitecture.data.remote.model.MuscleRemote;
import ru.swift.moderncleanarchitecture.domain.model.Muscle;

import static org.assertj.core.api.Assertions.assertThat;

public class MuscleRemoteDataMapperTest {

    private static final int EXPECTED_ID = 12;
    private static final String EXPECTED_NAME = "Triceps brachii";
    private static final boolean EXPECTED_IS_FRONT = true;

    // SUT
    private MuscleRemoteDataMapper mapper;

    @Before
    public void setUp() {
        mapper = MuscleRemoteDataMapper.INSTANCE;
    }

    @Test
    public void shouldTransformFromMuscleRemoteToMuscle() {
        Muscle actual = mapper.transform(createFakeMuscleRemote());

        assertThat(actual.getId()).isEqualTo(EXPECTED_ID);
        assertThat(actual.getName()).isEqualTo(EXPECTED_NAME);
        assertThat(actual.isFront()).isEqualTo(EXPECTED_IS_FRONT);
    }

    private MuscleRemote createFakeMuscleRemote() {
        MuscleRemote muscleRemote = new MuscleRemote();
        muscleRemote.setId(EXPECTED_ID);
        muscleRemote.setName(EXPECTED_NAME);
        muscleRemote.setFront(EXPECTED_IS_FRONT);
        return muscleRemote;
    }

}
