package ru.swift.moderncleanarchitecture.data.remote.mapper;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    @Test
    public void shouldTransformListFromExerciseCategoryRemoteToExerciseCategory() {
        List<ExerciseCategoryRemote> original = new ArrayList<>(
                Collections.singleton(createFakeExerciseCategoryRemote()));
        List<ExerciseCategory> actual = mapper.transform(original);

        assertThat(actual.get(0).getId()).isEqualTo(EXPECTED_ID);
        assertThat(actual.get(0).getName()).isEqualTo(EXPECTED_NAME);
    }

    private ExerciseCategoryRemote createFakeExerciseCategoryRemote() {
        ExerciseCategoryRemote exerciseCategoryRemote = new ExerciseCategoryRemote();
        exerciseCategoryRemote.setId(EXPECTED_ID);
        exerciseCategoryRemote.setName(EXPECTED_NAME);
        return exerciseCategoryRemote;
    }

}
