package com.Glasses4Child.project.repositories;

import com.Glasses4Child.project.entities.Login;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ConstraintViolationException;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LoginRepositoryTest {

    @Autowired
    private LoginRepository loginRepository;

    @Test
    public void checkValidMail(){
        Login login = new Login("testes.com", "12345");

        try {
            loginRepository.save(login);
            Assert.fail();
        }catch (ConstraintViolationException exception){
            Assert.assertEquals("javax.validation.ConstraintViolationException: Validation failed for classes [com.Glasses4Child.project.entities.Login] during persist time for groups [javax.validation.groups.Default, ]\n" +
                    "List of constraint violations:[\n" +
                    "\tConstraintViolationImpl{interpolatedMessage='não é um endereço de e-mail', propertyPath=email, rootBeanClass=class com.Glasses4Child.project.entities.Login, messageTemplate='{javax.validation.constraints.Email.message}'}\n" +
                    "]", exception.toString());
        }
    }
}