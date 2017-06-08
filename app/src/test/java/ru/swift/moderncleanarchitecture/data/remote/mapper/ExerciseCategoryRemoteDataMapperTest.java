package ru.swift.moderncleanarchitecture.data.remote.mapper;

import org.junit.Before;
import org.junit.Test;

import ru.swift.moderncleanarchitecture.data.remote.model.ExerciseCategoryRemote;
import ru.swift.moderncleanarchitecture.domain.model.ExerciseCategory;

import static org.assertj.core.api.Assertions.assertThat;

public class ExerciseCategoryRemoteDataMapperTest {

    private static final int EXPECTED_ID = 12;
    private static final String EXPECTED_NAME = "name";

    // SUT
    private ExerciseCategoryRemoteDataMapper mapper;

    @Before
    public void setUp() {
        mapper = ExerciseCategoryRemoteDataMapper.INSTANCE;
    }

    @Test
    public void shouldTransformFromExerciseCategoryRemoteToExerciseCategory() {
        ExerciseCategory actual = mapper.transform(createFakeExerciseCategoryRemote());

        assertThat(actual.getId()).isEqualTo(EXPECTED_ID);
        assertThat(actual.getName()).isEqualTo(EXPECTED_NAME);
    }

    private ExerciseCategoryRemote createFakeExerciseCategoryRemote() {
        ExerciseCategoryRemote exerciseCategoryRemote = new ExerciseCategoryRemote();
        exerciseCategoryRemote.setId(EXPECTED_ID);
        exerciseCategoryRemote.setName(EXPECTED_NAME);
        return exerciseCategoryRemote;
    }

}
