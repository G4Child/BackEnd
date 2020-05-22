package com.Glass4Child.project.config;

import com.Glass4Child.project.entities.*;
import com.Glass4Child.project.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.text.SimpleDateFormat;
import java.time.Instant;
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
    private DonateRepository DonateRepository;

    @Autowired
    private GlasseRepository GlasseRepository;
    @Autowired
    private DegreeRepository DegreeRepository;
    @Autowired
    private PaymentRepository PaymentRepository;
    @Autowired
    private RecordRepository RecordRepository;

    public void run(String... args) throws Exception {
        Payment py1 = new Payment(Instant.parse("1990-01-01T12:10:00.000Z"), "boleto");
        Payment py2 = new Payment(Instant.parse("1990-01-01T12:10:00.000Z"), "cartao");
        Payment py3 = new Payment(Instant.parse("1981-12-01T12:10:00.000Z"), "dinheiro");
        PaymentRepository.saveAll(Arrays.asList(py1, py2,py3));

        ArrayList<Payment> paymentList = new ArrayList<>();
        paymentList.add(py1);
        paymentList.add(py2);
        Degree de1 = new Degree("1", "2", "3", "4", "5", "6", "7", "8");
        Degree de2 = new Degree("1", "2", "3", "4", "5", "6", "7", "8");
        DegreeRepository.saveAll(Arrays.asList(de1, de2));

        Prescription presc = new Prescription("exame1", de2, de1);

        PrescriptionRepository.saveAll(Arrays.asList(presc));

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        ArrayList<Dependent> dependentsList = new ArrayList<Dependent>();
        Dependent dep1 = new Dependent("piralho", "155155", "11-05", "filhao", presc);
        Dependent dep2 = new Dependent("piralha", "155154", "10-05", "filha", presc);
        dependentsList.add(dep1);
        dependentsList.add(dep2);

        DependentRepository.saveAll(Arrays.asList(dep1, dep2));
        Address ad1 = new Address(5859, "Residencial Masculino", "SP", "Sao Paulo", "Capão Redondo", "UNASP", "Estrada de Itapecerica");
        Address ad2 = new Address(1349, null, "SP", "Sao Paulo", "Berrini", "Praça no inicio da Berrini", "Rua Arizona");
        Address ad3 = new Address(1520, null, "SP", "Sao Paulo", "Berrini", "Sem referências", "Av Berrini");
        addressRepository.saveAll(Arrays.asList(ad1, ad2, ad3));

        Beneficent beneficent1 = new Beneficent("Thales Oliveira", (long) 119999, "12345678", 300, "T-Thalles", formatter.parse("1985-05-05"), ad1);
        Beneficent beneficent2 = new Beneficent("Thauã Oliveira", (long) 219999, "123456789", 500, 500, "Sr-Thauã", formatter.parse("1985-05-05"), ad2);
        Beneficent beneficent3 = new Beneficent("cauã Oliver", (long) 21666, "547474", 500, 500, "Sr-cauã", formatter.parse("1985-05-05"), ad2);
        beneficentRepository.saveAll(Arrays.asList(beneficent1, beneficent2, beneficent3));

        Benefited benefited1 = new Benefited("Joao Alves", (long) 11921921, "394821911", 2, 3, "2020211", formatter.parse("1985-05-05"), ad3, dependentsList);
        benefitedRepository.saveAll(Arrays.asList(benefited1));



        Glasses glasses1 = new Glasses(150);
        Glasses glasses2 = new Glasses(300);
        Glasses glasses3 = new Glasses(600);
        ArrayList<Glasses> glassesList = new ArrayList<Glasses>();
        glassesList.add(glasses1);
        glassesList.add(glasses2);

        GlasseRepository.saveAll(Arrays.asList(glasses1, glasses2, glasses3));
        Donate donate = new Donate(Instant.parse("2020-01-01T12:10:00.000Z"), "150",  beneficent1, dep1);
        Donate donate1 = new Donate(Instant.parse("2019-11-01T12:10:00.000Z"), "300", beneficent1, dep1);
        DonateRepository.saveAll(Arrays.asList(donate,donate1));
        Record rec1 = new Record(formatter.parse("1985-05-05"), "ativo",paymentList,donate1,glasses1);
        Record rec2 = new Record(formatter.parse("1985-06-05"), "no ativo",paymentList,donate,glasses2);
        ArrayList<Record> recordsList = new ArrayList<>();
        recordsList.add(rec1);
        recordsList.add(rec2);
        RecordRepository.saveAll(Arrays.asList(rec1, rec2));
    }
}