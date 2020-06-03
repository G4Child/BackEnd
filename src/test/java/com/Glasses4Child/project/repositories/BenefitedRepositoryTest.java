package com.Glasses4Child.project.repositories;

import com.Glasses4Child.project.entities.Address;
import com.Glasses4Child.project.entities.Beneficent;
import com.Glasses4Child.project.entities.Benefited;
import com.Glasses4Child.project.entities.Login;
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
class BenefitedRepositoryTest {

    @Autowired
    BenefitedRepository benefitedRepository;
    @Autowired
    private LoginRepository loginRepository;
    @Autowired
    private AddressRepository addressRepository;

    @Test
    @SneakyThrows
    void mustPersistBenefitedData() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Address addressUnit = new Address (581, null, "SP", "Sao Paulo", "Santo Amaro", "Otica", "Av Sto Amaro");
        addressRepository.save(addressUnit);
        Login loginUnit = new Login("beneficent.junit@teste.com.br", "12345");
        loginRepository.save(loginUnit);
        Benefited benefitedUnit = new Benefited("Joao Alves", (long) 11921921, "394801211911", 2, 3, "2020219", formatter.parse("1985-05-05"), addressUnit, loginUnit);
        benefitedRepository.save(benefitedUnit);

        Assert.assertEquals(benefitedRepository.findByDocument("394801211911").getDocument(), benefitedUnit.getDocument());
        Assert.assertEquals(benefitedRepository.findByDocument("394801211911").toString(), benefitedUnit.toString().trim());
    }
}