package ru.swift.moderncleanarchitecture.data.remote.mapper;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

import ru.swift.moderncleanarchitecture.data.remote.model.EquipmentRemote;
import ru.swift.moderncleanarchitecture.data.remote.model.ExerciseCategoryRemote;
import ru.swift.moderncleanarchitecture.data.remote.model.ExerciseInfoRemote;
import ru.swift.moderncleanarchitecture.data.remote.model.MuscleRemote;
import ru.swift.moderncleanarchitecture.domain.model.ExerciseInfo;

import static org.assertj.core.api.Assertions.assertThat;

public class ExerciseInfoRemoteDataMapperTest {

    private static final String EXPECTED_NAME = "name";
    private static final String EXPECTED_DESCRIPTION = "description";

    private static final int EXPECTED_EXERCISE_CATEGORY_ID = 1;
    private static final int EXPECTED_MUSCLE_ID = 2;
    private static final int EXPECTED_MUSCLE_SECONDARY_ID = 3;
    private static final int EXPECTED_EQUIPMENT_ID = 4;

    // SUT
    private ExerciseInfoRemoteDataMapper mapper;

    @Before
    public void setUp() {
        mapper = ExerciseInfoRemoteDataMapper.INSTANCE;
    }

    @Test
    public void shouldTransformFromExerciseInfoRemoteToExerciseInfo() {
        ExerciseInfo actual = mapper.transform(createFakeExerciseInfoRemote());

        // let's check it this way, cuz we can't mock other mappers
        assertThat(actual.getName()).isEqualTo(EXPECTED_NAME);
        assertThat(actual.getCategory().getId()).isEqualTo(EXPECTED_EXERCISE_CATEGORY_ID);
        assertThat(actual.getDescription()).isEqualTo(EXPECTED_DESCRIPTION);
        assertThat(actual.getMuscles())
                .extracting("id")
                .containsExactly(EXPECTED_MUSCLE_ID);
        assertThat(actual.getMusclesSecondary())
                .extracting("id")
                .containsExactly(EXPECTED_MUSCLE_SECONDARY_ID);
        assertThat(actual.getEquipmentList())
                .extracting("id")
                .containsExactly(EXPECTED_EQUIPMENT_ID);
    }

    private ExerciseInfoRemote createFakeExerciseInfoRemote() {
        ExerciseInfoRemote exerciseInfoRemote = new ExerciseInfoRemote();
        exerciseInfoRemote.setName(EXPECTED_NAME);
        exerciseInfoRemote.setDescription(EXPECTED_DESCRIPTION);

        ExerciseCategoryRemote exerciseCategoryRemote = new ExerciseCategoryRemote();
        exerciseCategoryRemote.setId(EXPECTED_EXERCISE_CATEGORY_ID);
        exerciseInfoRemote.setCategory(exerciseCategoryRemote);

        MuscleRemote muscleRemote = new MuscleRemote();
        muscleRemote.setId(EXPECTED_MUSCLE_ID);
        exerciseInfoRemote.setMuscles(new ArrayList<>(Collections.singleton(muscleRemote)));

        MuscleRemote muscleSecondaryRemote = new MuscleRemote();
        muscleSecondaryRemote.setId(EXPECTED_MUSCLE_SECONDARY_ID);
        exerciseInfoRemote.setMusclesSecondary(
                new ArrayList<>(Collections.singleton(muscleSecondaryRemote)));

        EquipmentRemote equipmentRemote = new EquipmentRemote();
        equipmentRemote.setId(EXPECTED_EQUIPMENT_ID);
        exerciseInfoRemote.setEquipmentList(new ArrayList<>(Collections.singleton(equipmentRemote)));

        return exerciseInfoRemote;
    }

}
