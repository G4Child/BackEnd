package com.Glasses4Child.project.repositories;

import com.Glasses4Child.project.entities.Address;
import com.Glasses4Child.project.entities.Beneficent;
import com.Glasses4Child.project.entities.Login;
import lombok.SneakyThrows;
import org.hibernate.id.IdentifierGenerationException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase
class BeneficentRepositoryTest {

    @Autowired
    private BeneficentRepository beneficentRepository;
    @Autowired
    private LoginRepository loginRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Rule
    public ExpectedException thrown = ExpectedException.none();


    @Test
    @SneakyThrows
    void shouldPersistBeneficentData() {
        thrown.expect(IdentifierGenerationException.class);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Login login = new Login("teste2@teste.com.br", "12345");
        loginRepository.save(login);
        Address address = new Address(1520, null, "SP", "Sao Paulo", "Berrini", "Sem referências", "Av Berrini");
        addressRepository.save(address);

        Beneficent beneficent = new Beneficent("Thales Oliveira", 11999912L, "63340982091", "T-Thalles", formatter.parse("1992-01-12"), address, login);
        beneficentRepository.save(beneficent);

        Assert.assertEquals(formatter.parse("1992-01-12"), beneficentRepository.findByDocument("63340982091").getBornDate());
        Assert.assertEquals("63340982091", beneficentRepository.findByDocument("63340982091").getDocument());
        Assert.assertEquals("Thales Oliveira", beneficentRepository.findByDocument("63340982091").getName());
        Assert.assertEquals("T-Thalles", beneficent.getPseudonym());
        Assert.assertEquals(11999912L, beneficentRepository.findByDocument("63340982091").getTelephone());
    }

    @Test
    public void createBeneficentWithNullFields() {
        Beneficent beneficent = new Beneficent();
        try {
            beneficentRepository.save(beneficent);
            Assert.fail();
        } catch (Exception exception) {
            Assert.assertTrue(exception.toString().contains(JpaSystemException.class.toString().substring(6)));
        }
    }

    @Test
    @SneakyThrows
    public void beneficentEqualAsSaved() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Login login = new Login("teste2beneficent@teste.com.br", "12345");
        loginRepository.save(login);
        Address address = new Address(1520, null, "SP", "Sao Paulo", "Berrini", "Sem referências", "Av Berrini");
        addressRepository.save(address);

        Beneficent beneficent = new Beneficent("Thales Oliveira", 118799912L, "63340982092", "T-Thalles", formatter.parse("1992-01-12"), address, login);
        beneficentRepository.save(beneficent);

        Assert.assertEquals("63340982092", beneficentRepository.findByDocument("63340982092").getDocument());
        Assert.assertEquals(beneficent, beneficentRepository.findByDocument("63340982092"));
    }
}
