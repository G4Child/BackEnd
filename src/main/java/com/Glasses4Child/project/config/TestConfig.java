package com.Glasses4Child.project.config;

import com.Glasses4Child.project.entities.*;
import com.Glasses4Child.project.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.text.SimpleDateFormat;
import java.util.*;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private BeneficentRepository beneficentRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private BenefitedRepository benefitedRepository;
    @Autowired
    private DependentRepository DependentRepository;
    @Autowired
    private PrescriptionRepository PrescriptionRepository;
    @Autowired
    private DonationRepository DonationRepository;
    @Autowired
    private com.Glasses4Child.project.repositories.GlassesRepository GlassesRepository;
    @Autowired
    private DegreeRepository DegreeRepository;
    @Autowired
    private PaymentRepository PaymentRepository;
    @Autowired
    private RecordRepository RecordRepository;
    @Autowired
    private GlassesStoreRepository glassesStoreRepository;
    @Autowired
    private LoginRepository loginRepository;

    public void run(String... args) throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

//       ################################### ADDRESS ##########################################
        Address address1 = new Address(5859, "Residencial Masculino", "SP", "Sao Paulo", "Capão Redondo", "UNASP", "Estrada de Itapecerica");
        Address address2 = new Address(1349, null, "SP", "Sao Paulo", "Berrini", "Praça no inicio da Berrini", "Rua Arizona");
        Address address3 = new Address(1520, null, "SP", "Sao Paulo", "Berrini", "Sem referências", "Av Berrini");
        Address addressGStore = new Address(581, null, "SP", "Sao Paulo", "Santo Amaro", "Otica", "Av Sto Amaro");
        Address addressGStoreF = new Address(680, null, "SP", "Sao Paulo", "Santo Amaro", "Otica Filial", "Av Sto Amaro");
        addressRepository.saveAll(Arrays.asList(address1, address2, address3, addressGStore, addressGStoreF));

//       ################################### LOGIN ##########################################
        Login login = new Login("teste@teste.com", "12345");
        Login login1 = new Login("teste1@teste.com", "12345");
        Login login2 = new Login("teste2@teste.com", "12345");
        Login login3 = new Login("teste3@teste.com", "12345");
        Login login4 = new Login("teste4@teste.com", "12345");
        Login login5 = new Login("teste5@teste.com", "12345");
        loginRepository.saveAll(Arrays.asList(login,login1, login2, login3, login4, login5));

//       ################################### BENEFICENT ##########################################
        Beneficent beneficent1 = new Beneficent("Thales Oliveira", 119999L, "63340982090",  "T-Thalles", formatter.parse("1985-05-05"), address1, login);
        Beneficent beneficent2 = new Beneficent("Artemis Vieira", 5511906L, "95791865457", "Rosha Guevi", formatter.parse("1958-02-24"), address2, login1);
        beneficentRepository.saveAll(Arrays.asList(beneficent1, beneficent2));

//       ################################### BENEFITED ##########################################
        Benefited benefited1 = new Benefited("Joao Alves", (long) 11921921, "394821911", 2, 3, "2020211", formatter.parse("1985-05-05"), address3, login2);
        benefitedRepository.save(benefited1);

//       ################################### DEPENDENT ##########################################
        Dependent dep1 = new Dependent("Joao Junior Alves", "Joazinho", "155151", formatter.parse("2008-12-05"), "Filho", benefited1);
        Dependent dep2 = new Dependent("Samilly Alves","Samy", "155152", formatter.parse("2009-01-05"), "Filha", benefited1);
        DependentRepository.saveAll(Arrays.asList(dep1, dep2));

//       ################################### DEGREE ##########################################
        Degree deg1 = new Degree("1", "2", "3", "4", "5", "6", "7", "8");
        Degree deg2 = new Degree("1", "2", "3", "4", "5", "6", "7", "8");
        DegreeRepository.saveAll(Arrays.asList(deg1, deg2));

//       ################################### PRESCRIPTION ##########################################
        Prescription prescription = new Prescription("s3-1", null, deg1, deg2, dep1);
        PrescriptionRepository.save(prescription);

//       ################################### DONATION ##########################################
        Donation donation = new Donation(150.0, beneficent1);
        DonationRepository.save(donation);

//       ################################### GLASSES STORE ##########################################
        GlassesStore glassesStore = new GlassesStore("OTICA-G4C", (long)118393198, "82189347000199", addressGStore, login4);
        GlassesStore glassesStoreAgency = new GlassesStore("OTICA-G4C-FILIAL", (long)118393199, "82189347000199", addressGStoreF, login5);
        glassesStoreRepository.saveAll(Arrays.asList(glassesStore,glassesStoreAgency));
//
//       ################################### GLASSES ##########################################
        Glasses glasses1 = new Glasses(150, dep1, glassesStore);
        Glasses glasses2 = new Glasses(300, dep2, glassesStoreAgency);
        GlassesRepository.saveAll(Arrays.asList(glasses1, glasses2));

//       ################################### RECORD ##########################################
        Record rec1 = new Record("STARTED", donation, glasses1);
        Record rec2 = new Record("STARTED", donation, glasses2);

        ArrayList<Record> recordsList = new ArrayList<>();
        recordsList.add(rec1);
        recordsList.add(rec2);
        RecordRepository.saveAll(Arrays.asList(rec1, rec2));

        ArrayList<Record> recordsList2 = new ArrayList<>();
        recordsList2.add(rec1);
        recordsList2.add(rec2);
        RecordRepository.save(rec1);

//       ################################### PAYMENT ##########################################
        Payment payment = new Payment("SLIP", 100.0, recordsList);
        Payment payment1 = new Payment("CREDIT", 300.0, recordsList2);
        PaymentRepository.saveAll(Arrays.asList(payment, payment1));
    }
}