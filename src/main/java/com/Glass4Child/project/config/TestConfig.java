package com.Glass4Child.project.config;

import com.Glass4Child.project.entities.Address;
import com.Glass4Child.project.entities.Beneficent;
import com.Glass4Child.project.repositories.AddressRepository;
import com.Glass4Child.project.repositories.BeneficentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private BeneficentRepository beneficentRepository;
    @Autowired
    private AddressRepository addressRepository;

    public void run(String... args) throws Exception {

        Address ad1 = new Address(5859, "Residencial Masculino", "SP", "Sao Paulo", "Capão Redondo", "UNASP", "Estrada de Itapecerica");
        Address ad2 = new Address(1349, null, "SP", "Sao Paulo", "Berrini", null, "Rua Arizona");

        Beneficent benef1 = new Beneficent("Thales Oliveira", "thales@gmail.com", (long) 119999, "password12345", "12345678", 300, "Mr-Thalles", ad1);
        Beneficent benef2 = new Beneficent("Thauã Oliveira", "thaua@gmail.com", (long) 219999, "password113", "123456789", 300, 500, "Mr-Thalles", ad2);

        addressRepository.saveAll(Arrays.asList(ad1, ad2));
        beneficentRepository.saveAll(Arrays.asList(benef1, benef2));
    }
}