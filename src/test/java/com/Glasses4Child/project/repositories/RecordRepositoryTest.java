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
class RecordRepositoryTest {

    @Autowired
    private BeneficentRepository beneficentRepository;
    @Autowired
    private LoginRepository loginRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private DonationRepository donationRepository;
    @Autowired
    private GlassesRepository glassesRepository;
    @Autowired
    private RecordRepository recordRepository;
    @Autowired
    private DependentRepository dependentRepository;
    @Autowired
    private BenefitedRepository benefitedRepository;
    @Autowired
    private GlassesStoreRepository glassesStoreRepository;

    @Test
    @SneakyThrows
    public void mustPersistRecordData(){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Login login = new Login("teste2record@teste.com.br", "12345");
        loginRepository.save(login);
        Address address = new Address(1520, null, "SP", "Sao Paulo", "Berrini", "Sem referências", "Av Berrini");
        addressRepository.save(address);

        Beneficent beneficent = new Beneficent("Thales Oliveira", 119911112L, "6322092122091", "T-Thalles", formatter.parse("1992-01-12"), address, login);
        beneficentRepository.save(beneficent);

        Donation donation = new Donation(150.0, beneficent);

        donationRepository.save(donation);

        Login login2 = new Login("teste.junit.record@teste.com", "12345");
        loginRepository.save(login2);

        Login login3 = new Login("teste.junit.r@teste.com", "12345");
        loginRepository.save(login);
        GlassesStore glassesStore = new GlassesStore("OTICA-G4C", 2141118393198L, "821893247000199", address, login);
        glassesStoreRepository.save(glassesStore);

        Login loginUnit = new Login("bneficent.junit2donate@teste.com", "12345");
        loginRepository.save(loginUnit);
        Benefited benefitedUnit = new Benefited("Joao Alves", 11922213921231L, "3294814191112", 2, 3, "20202198", formatter.parse("1985-05-05"), address, loginUnit);
        benefitedRepository.save(benefitedUnit);

        Dependent dependent = new Dependent("Joao Junior Alves", "Jaozinho199", "18938293819", formatter.parse("2008-12-05"), "Filho", benefitedUnit);
        dependentRepository.save(dependent);

        Glasses glasses = new Glasses(150, dependent, glassesStore);
        glassesRepository.save(glasses);

//        Record record = new Record("STARTED", donationRepository.findById(1L).get(), glassesRepository.findById(1L).get());
        Record record = new Record("STARTED", donation, glasses);
        recordRepository.save(record);

        Assertions.assertEquals(record.getDonation(), recordRepository.findById(record.getId()).get().getDonation());
    }
}