package com.Glasses4Child.project.repositories;

import com.Glasses4Child.project.entities.Address;
import com.Glasses4Child.project.entities.GlassesStore;
import com.Glasses4Child.project.entities.Login;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase
class GlassesStoreRepositoryTest {

    @Autowired
    private LoginRepository loginRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private GlassesStoreRepository glassesStoreRepository;


    @Test
    public void mustPersistGlassesStoreData(){
        Address address = new Address (581, null, "SP", "Sao Paulo", "Santo Amaro", "Otica", "Av Sto Amaro");
        addressRepository.save(address);
        Login login = new Login("teste.junit@teste.com", "12345");
        loginRepository.save(login);

        GlassesStore glassesStore = new GlassesStore("OTICA-G4C", 118393198L, "82189347000199", address, login);
        glassesStoreRepository.save(glassesStore);

        Assert.assertEquals(glassesStore.getDocument(),"82189347000199");
        Assert.assertEquals(glassesStore.getName(), "OTICA-G4C");
        Assert.assertEquals(glassesStore.getAddress(), address);
        Assert.assertEquals(glassesStore.getLogin(), login);
    }

    @Test
    public void checkIfDocumentIsNotNull(){
        Address address = new Address (581, null, "SP", "Sao Paulo", "Santo Amaro", "Otica", "Av Sto Amaro");
        addressRepository.save(address);
        Login login = new Login("teste.junit2@teste.com", "12345");
        loginRepository.save(login);

        GlassesStore glassesStore = new GlassesStore("OTICA-G4C", 118393198L, null, address, login);

        try {
            glassesStoreRepository.save(glassesStore);
            Assert.fail();
        } catch (Exception exception){
            Assert.assertTrue(exception.toString().contains((DataIntegrityViolationException.class).toString().substring(6)));
        }
    }

    @Test
    public void checkIfGlassesStoreExists(){
        Address address = new Address (581, null, "SP", "Sao Paulo", "Santo Amaro", "Otica", "Av Sto Amaro");
        addressRepository.save(address);
        Login login = new Login("teste.junit3@teste.com", "12345");
        loginRepository.save(login);

        GlassesStore glassesStore = new GlassesStore("OTICA-G4C", 118393118L, "82189347000199", address, login);
        GlassesStore glassesStore2 = new GlassesStore("OTICA-G4C", 118393118L, "82189347000199", address, login);
        glassesStoreRepository.save(glassesStore);

        try {
            glassesStoreRepository.save(glassesStore2);
            Assert.fail();
        } catch (Exception exception){
            Assert.assertTrue(exception.toString().contains((DataIntegrityViolationException.class).toString().substring(6)));
        }
    }

    @Test
    public void checkIfGlassesStoreHaveLogin(){
        Address address = new Address (581, null, "SP", "Sao Paulo", "Santo Amaro", "Otica", "Av Sto Amaro");
        addressRepository.save(address);
        GlassesStore glassesStore = new GlassesStore("OTICA-G4C", 1183931901L, "82189347000199", address, null);

        try {
            glassesStoreRepository.save(glassesStore);
            Assert.fail();
        } catch (Exception exception){
            Assert.assertTrue(exception.toString().contains((DataIntegrityViolationException.class).toString().substring(6)));
        }
    }

    @Test
    public void checkIfGlassesStoreHaveAddress(){
        Login login = new Login("teste.junit8@teste.com", "12345");
        loginRepository.save(login);
        GlassesStore glassesStore = new GlassesStore("OTICA-G4C", 118393198L, "82189347000199", null, login);

        try {
            glassesStoreRepository.save(glassesStore);
            Assert.fail();
        } catch (Exception exception){
            Assert.assertTrue(exception.toString().contains((DataIntegrityViolationException.class).toString().substring(6)));
        }
    }
}