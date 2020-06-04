package com.Glasses4Child.project.repositories;

import com.Glasses4Child.project.entities.Degree;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase
class DegreeRepositoryTest {

    @Autowired
    DegreeRepository degreeRepository;

    @Test
    public void mustPersistDegreeData() {
        Degree deg = new Degree("1", "2", "3", "4", "5", "6", "7", "8");
        degreeRepository.save(deg);

        Assertions.assertEquals(deg.getAxis_L(), degreeRepository.findById(deg.getId()).get().getAxis_L());
        Assertions.assertEquals(deg.getId(), degreeRepository.findById(deg.getId()).get().getId());
        Assertions.assertEquals(deg.getSphere_R(), degreeRepository.findById(deg.getId()).get().getSphere_R());
    }
}