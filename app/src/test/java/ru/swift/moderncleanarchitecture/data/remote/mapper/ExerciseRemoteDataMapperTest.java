package ru.swift.moderncleanarchitecture.data.remote.mapper;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ru.swift.moderncleanarchitecture.data.remote.model.ExerciseRemote;
import ru.swift.moderncleanarchitecture.domain.model.Exercise;

import static org.assertj.core.api.Assertions.assertThat;

public class ExerciseRemoteDataMapperTest {

    private static final int EXPECTED_ID = 14;
    private static final String EXPECTED_LICENSE_AUTHOR = "author";
    private static final String EXPECTED_STATUS = "status";
    private static final String EXPECTED_DESCRIPTION = "description";
    private static final String EXPECTED_NAME = "name";
    private static final String EXPECTED_NAME_ORIGINAL = "original name";
    private static final String EXPECTED_CREATION_DATE = "08.06.2017";
    private static final String EXPECTED_UUID = "uuid";
    private static final int EXPECTED_LICENSE_ID = 1;
    private static final int EXPECTED_CATEGORY_ID = 8;
    private static final int EXPECTED_LANGUAGE_ID = 2;
    private List<Integer> expectedMusclesIds;
    private List<Integer> expectedMusclesSecondaryIds;
    private List<Integer> expectedEquipmentIds;

    // SUT
    private ExerciseRemoteDataMapper mapper;

    @Before
    public void setUp() {
        mapper = ExerciseRemoteDataMapper.INSTANCE;
    }

    @Test
    public void shouldTransformFromExerciseRemoteToExercise() {
        Exercise actual = mapper.transform(createFakeExerciseRemote());

        assertThat(actual.getId()).isEqualTo(EXPECTED_ID);
        assertThat(actual.getLicenseAuthor()).isEqualTo(EXPECTED_LICENSE_AUTHOR);
        assertThat(actual.getStatus()).isEqualTo(EXPECTED_STATUS);
        assertThat(actual.getDescription()).isEqualTo(EXPECTED_DESCRIPTION);
        assertThat(actual.getName()).isEqualTo(EXPECTED_NAME);
        assertThat(actual.getNameOriginal()).isEqualTo(EXPECTED_NAME_ORIGINAL);
        assertThat(actual.getCreationDate()).isEqualTo(EXPECTED_CREATION_DATE);
        assertThat(actual.getUuid()).isEqualTo(EXPECTED_UUID);
        assertThat(actual.getLicenseId()).isEqualTo(EXPECTED_LICENSE_ID);
        assertThat(actual.getCategoryId()).isEqualTo(EXPECTED_CATEGORY_ID);
        assertThat(actual.getLanguageId()).isEqualTo(EXPECTED_LANGUAGE_ID);
        assertThat(actual.getMusclesIds()).isEqualTo(expectedMusclesIds);
        assertThat(actual.getMusclesSecondaryIds()).isEqualTo(expectedMusclesSecondaryIds);
        assertThat(actual.getEquipmentIds()).isEqualTo(expectedEquipmentIds);
    }

    private ExerciseRemote createFakeExerciseRemote() {
        ExerciseRemote exerciseRemote = new ExerciseRemote();
        exerciseRemote.setId(EXPECTED_ID);
        exerciseRemote.setLicenseAuthor(EXPECTED_LICENSE_AUTHOR);
        exerciseRemote.setStatus(EXPECTED_STATUS);
        exerciseRemote.setDescription(EXPECTED_DESCRIPTION);
        exerciseRemote.setName(EXPECTED_NAME);
        exerciseRemote.setNameOriginal(EXPECTED_NAME_ORIGINAL);
        exerciseRemote.setCreationDate(EXPECTED_CREATION_DATE);
        exerciseRemote.setUuid(EXPECTED_UUID);
        exerciseRemote.setLicenseId(EXPECTED_LICENSE_ID);
        exerciseRemote.setCategoryId(EXPECTED_CATEGORY_ID);
        exerciseRemote.setLanguageId(EXPECTED_LANGUAGE_ID);
        expectedMusclesIds = new ArrayList<>(Collections.singleton(1));
        exerciseRemote.setMusclesIds(expectedMusclesIds);
        expectedMusclesSecondaryIds = new ArrayList<>(Collections.singleton(2));
        exerciseRemote.setMusclesSecondaryIds(expectedMusclesSecondaryIds);
        expectedEquipmentIds = new ArrayList<>(Collections.singleton(3));
        exerciseRemote.setEquipmentIds(expectedEquipmentIds);
        return exerciseRemote;
    }

}
