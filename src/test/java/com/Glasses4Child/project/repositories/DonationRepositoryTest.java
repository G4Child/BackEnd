package com.Glasses4Child.project.repositories;

import com.Glasses4Child.project.entities.Address;
import com.Glasses4Child.project.entities.Beneficent;
import com.Glasses4Child.project.entities.Donation;
import com.Glasses4Child.project.entities.Login;
import lombok.SneakyThrows;
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
class DonationRepositoryTest {

    @Autowired
    private BeneficentRepository beneficentRepository;
    @Autowired
    private LoginRepository loginRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private DonationRepository donationRepository;

    @Test
    @SneakyThrows
    public void mustPersistDonationData() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Login login = new Login("teste2donation@teste.com.br", "12345");
        loginRepository.save(login);
        Address address = new Address(1520, null, "SP", "Sao Paulo", "Berrini", "Sem referências", "Av Berrini");
        addressRepository.save(address);

        Beneficent beneficent = new Beneficent("Thales Oliveira", 11991112L, "6334092122091", "T-Thalles", formatter.parse("1992-01-12"), address, login);
        beneficentRepository.save(beneficent);

        Donation donation = new Donation(150.0, beneficent);

        donationRepository.save(donation);
        donation.getId();

        Assertions.assertEquals(donation.getAmount(), donationRepository.findById(donation.getId()).get().getAmount());
    }
}