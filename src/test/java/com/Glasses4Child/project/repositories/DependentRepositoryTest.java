package com.Glasses4Child.project.repositories;

import com.Glasses4Child.project.entities.Address;
import com.Glasses4Child.project.entities.Benefited;
import com.Glasses4Child.project.entities.Dependent;
import com.Glasses4Child.project.entities.Login;
import lombok.SneakyThrows;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase
class DependentRepositoryTest {

    @Autowired
    private BenefitedRepository benefitedRepository;
    @Autowired
    private LoginRepository loginRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private DependentRepository dependentRepository;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @SneakyThrows
    @Test
    public void mustPersistDependentData(){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        Address addressUnit = new Address (581, null, "SP", "Sao Paulo", "Santo Amaro", "Otica", "Av Sto Amaro");
        addressRepository.save(addressUnit);
        Login loginUnit = new Login("bneficent.junit@teste.com", "12345");
        loginRepository.save(loginUnit);
        Benefited benefitedUnit = new Benefited("Joao Alves", (long) 11921921, "394821191112", 2, 3, "2020213", formatter.parse("1985-05-05"), addressUnit, loginUnit);
        benefitedRepository.save(benefitedUnit);

        String document = "15515112812";

        Dependent dependent = new Dependent("Joao Junior Alves", "Jaozinho", document, formatter.parse("2008-12-05"), "Filho", benefitedUnit);
        dependentRepository.save(dependent);

        Assert.assertEquals(dependent.getDocument(), dependentRepository.findByDocument(document).getDocument());
        Assert.assertEquals(dependent.getNome(), dependentRepository.findByDocument(document).getNome());
        Assert.assertEquals(dependent.isActive(), dependentRepository.findByDocument(document).isActive());
    }


    @Test
    @SneakyThrows
    public void checkIfDependentHasBenefited(){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Dependent dependent = new Dependent("Joao Junior Alves", "Jaozinho", "1551511289", formatter.parse("2008-12-05"), "Filho", null);

        try {
            dependentRepository.save(dependent);
            Assert.fail();
        } catch (Exception exception) {
            Assert.assertTrue(exception.toString().contains(DataIntegrityViolationException.class.toString().substring(6)));
        }
    }

    @SneakyThrows
    @Test
    public void checkIfDependentAlreadyExists(){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        Address addressUnit = new Address (581, null, "SP", "Sao Paulo", "Santo Amaro", "Otica", "Av Sto Amaro");
        addressRepository.save(addressUnit);
        Login loginUnit = new Login("beneficent.junit@teste.com", "12345");
        loginRepository.save(loginUnit);
        Benefited benefitedUnit = new Benefited("Joao Alves", (long) 11921921, "394821911", 2, 3, "2020211", formatter.parse("1985-05-05"), addressUnit, loginUnit);
        benefitedRepository.save(benefitedUnit);

        String document = "1551511289";

        Dependent dependent = new Dependent("Joao Junior Alves", "Jaozinho12", document, formatter.parse("2008-12-05"), "Filho", benefitedUnit);
        dependentRepository.save(dependent);

        Dependent dependent2 = new Dependent("Joao Junior Alves", "Jaozinho", document, formatter.parse("2008-12-05"), "Filho", benefitedUnit);
        try {
            dependentRepository.save(dependent2);
            Assert.fail();
        } catch (Exception exception) {
            Assert.assertTrue(exception.toString().contains(DataIntegrityViolationException.class.toString().substring(6)));
        }
    }
}