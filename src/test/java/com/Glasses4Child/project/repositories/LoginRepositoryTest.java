package com.Glasses4Child.project.repositories;

import com.Glasses4Child.project.entities.Login;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import javax.validation.ConstraintViolationException;

@ActiveProfiles("test")
//@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase
public class LoginRepositoryTest {

    @Autowired
    private LoginRepository loginRepository;

    @Test
    public void checkIfEmailFormatIsValid() {
        try {
            Login login = new Login("gmail.com", "12345");
            loginRepository.save(login);
            Assert.fail();
        } catch (Exception exception) {
            Assert.assertTrue(exception.toString().contains(ConstraintViolationException.class.toString().substring(6)));
        }

        try {
            Login login2 = new Login("testes@", "12345");
            loginRepository.save(login2);
            Assert.fail();
        } catch (Exception exception) {
            Assert.assertEquals(exception.toString().substring(0, 45), ConstraintViolationException.class.toString().substring(6));
        }
    }

    @Test
    public void checkLoginDataPersistence() {
        Login login = new Login("emailLogin@repo.com", "password99");
        loginRepository.save(login);

        Assert.assertEquals(loginRepository.findByEmail("emailLogin@repo.com").getEmail(), "emailLogin@repo.com");
        Assert.assertEquals(loginRepository.findByEmail("emailLogin@repo.com").getPassword(), "password99");
    }

    public void teste21(){

    }
}