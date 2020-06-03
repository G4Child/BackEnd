package com.Glasses4Child.project.repositories;

import com.Glasses4Child.project.entities.Address;
import com.Glasses4Child.project.entities.Beneficent;
import com.Glasses4Child.project.entities.Benefited;
import com.Glasses4Child.project.entities.Login;
import com.Glasses4Child.project.services.LoginService;
import org.assertj.core.api.Assertions;
import org.hibernate.id.IdentifierGenerationException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@DataJpaTest
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
    void shouldPersistBeneficentData() {
        thrown.expect(IdentifierGenerationException.class);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Login login = new Login("teste2@teste.com.br", "12345");
        loginRepository.save(login);
        Address address = new Address(1520, null, "SP", "Sao Paulo", "Berrini", "Sem referências", "Av Berrini");
        addressRepository.save(address);
        Beneficent beneficent = null;
        try {
            beneficent = new Beneficent("Thales Oliveira",11999912L, "63340982091", "T-Thalles", formatter.parse("1992-01-12"), address, login);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        beneficentRepository.save(beneficent);
        System.out.println(beneficent);
        Assert.assertEquals(beneficent.getBornDate(),(new Date(92, Calendar.JANUARY, 12)));
        Assert.assertEquals(beneficent.getDocument(), ("63340982091"));
        Assert.assertEquals(beneficent.getName(), ("Thales Oliveira"));
        Assert.assertEquals(beneficent.getPseudonym(), ("T-Thalles"));
        Assertions.assertThat(beneficent.getTelephone()).isEqualTo(11999912);
        Assert.assertEquals(beneficent.getDocument(), ("63340982091"));
    }

    @Test
    void createBeneficentWithNullFields() {
        Beneficent beneficent = new Beneficent();
        try {
            beneficentRepository.save(beneficent);
            Assert.fail();
        } catch (JpaSystemException exception) {
            Assert.assertEquals("org.springframework.orm.jpa.JpaSystemException: ids for this class must be manually assigned before calling save(): com.Glasses4Child.project.entities.Beneficent; nested exception is org.hibernate.id.IdentifierGenerationException: ids for this class must be manually assigned before calling save(): com.Glasses4Child.project.entities.Beneficent", exception.toString());
        }
    }

    @Test
    void findByDocument() {
    }

    @Test
    void deleteByDocument() {
    }
}
