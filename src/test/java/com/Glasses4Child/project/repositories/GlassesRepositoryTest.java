package com.Glasses4Child.project.repositories;

import com.Glasses4Child.project.entities.*;
import lombok.SneakyThrows;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
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
class GlassesRepositoryTest {

    @Autowired
    GlassesRepository glassesRepository;
    @Autowired
    GlassesStoreRepository glassesStoreRepository;
    @Autowired
    private LoginRepository loginRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private DependentRepository dependentRepository;
    @Autowired
    private BenefitedRepository benefitedRepository;

    @Test
    @SneakyThrows
    public void mustPersistGlassData() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        Address address = new Address(581, null, "SP", "Sao Paulo", "Santo Amaro", "Otica", "Av Sto Amaro");
        addressRepository.save(address);
        Login login = new Login("teste.junit.d@teste.com", "12345");
        loginRepository.save(login);
        GlassesStore glassesStore = new GlassesStore("OTICA-G4C", 214118393198L, "82189347000199", address, login);
        glassesStoreRepository.save(glassesStore);

        Login loginUnit = new Login("bneficent.junit.d@teste.com", "12345");
        loginRepository.save(loginUnit);
        Benefited benefitedUnit = new Benefited("Joao Alves", (long) 1192113921, "394814191112", 2, 3, "2020213", formatter.parse("1985-05-05"), address, loginUnit);
        benefitedRepository.save(benefitedUnit);

        Dependent dependent = new Dependent("Joao Junior Alves", "Jaozinho190", "18938193819", formatter.parse("2008-12-05"), "Filho", benefitedUnit);
        dependentRepository.save(dependent);

        Glasses glasses = new Glasses(150, dependent, glassesStore);
        glassesRepository.save(glasses);

        Assertions.assertEquals(glasses.getPrice(), glassesRepository.findById(glasses.getId()).get().getPrice());
    }
}