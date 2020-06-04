package com.Glasses4Child.project.repositories;

import com.Glasses4Child.project.entities.*;
import lombok.SneakyThrows;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase
class PrescriptionRepositoryTest {

    @Autowired
    DegreeRepository degreeRepository;
    @Autowired
    PrescriptionRepository prescriptionRepository;
    @Autowired
    private BenefitedRepository benefitedRepository;
    @Autowired
    private LoginRepository loginRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private DependentRepository dependentRepository;

    @Test
    @SneakyThrows
    public void shouldPersistPrescriptionData() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        Address addressUnit = new Address(581, null, "SP", "Sao Paulo", "Santo Amaro", "Otica", "Av Sto Amaro");
        addressRepository.save(addressUnit);
        Login loginUnit = new Login("bneficent.junit.presc@teste.com", "12345");
        loginRepository.save(loginUnit);
        Benefited benefitedUnit = new Benefited("Joao Alves", (long) 119121921, "3943821191112", 2, 3, "20203253", formatter.parse("1985-05-05"), addressUnit, loginUnit);
        benefitedRepository.save(benefitedUnit);

        Dependent dependent = new Dependent("Joao Junior Alves", "Jaozinho7421", "155151122812", formatter.parse("2008-12-05"), "Filho", benefitedUnit);
        dependentRepository.save(dependent);

        Degree deg = new Degree("1", "2", "3", "4", "5", "6", "7", "8");
        degreeRepository.save(deg);
        Prescription prescription = new Prescription("s3-2", null, null, deg, dependent);
        prescriptionRepository.save(prescription);

        Assert.assertEquals(prescription.getId(),prescriptionRepository.findById(prescription.getId()).get().getId());
    }
}