package com.Glass4Child.project.config;

import com.Glass4Child.project.entities.*;
import com.Glass4Child.project.repositories.*;
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
    private DonateRepository DonateRepository;

    @Autowired
    private GlasseRepository GlasseRepository;
    @Autowired
    private DegreeRepository DegreeRepository;
    @Autowired
    private PaymentRepository PaymentRepository;
    public void run(String... args) throws Exception {
        SimpleDateFormat fformatter = new SimpleDateFormat("yyyy-MM-dd");
        fformatter.parse("1985-05-05");
        Payment py1=new Payment(fformatter.parse("1985-05-05"),"boleto");
        Payment py2=new Payment(fformatter.parse("1985-05-05"),"cartao");
        PaymentRepository.saveAll(Arrays.asList(py1,py2));
        ArrayList<Payment> lpy=new ArrayList<>();
        lpy.add(py1);
        lpy.add(py2);
        Degree de1=new Degree("1","2","3","4","5","6","7","8");
        Degree de2=new Degree("1","2","3","4","5","6","7","8");
        DegreeRepository.saveAll(Arrays.asList(de1,de2));

        Prescription p1=new Prescription("exame1",de2,de1);
        PrescriptionRepository.saveAll(Arrays.asList(p1));
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        ArrayList<Dependent> ld=new ArrayList<Dependent>();
        Dependent d1 = new Dependent( "piralho","155155","11-05","filhao",p1);
        Dependent d2=new Dependent( "piralha","155154","10-05","filha",p1);
        ld.add(d1);
        ld.add(d2);
        DependentRepository.saveAll(Arrays.asList(d1,d2));
        Address ad1 = new Address(5859, "Residencial Masculino", "SP", "Sao Paulo", "Capão Redondo", "UNASP", "Estrada de Itapecerica");
        Address ad2 = new Address(1349, null, "SP", "Sao Paulo", "Berrini", "Praça no inicio da Berrini", "Rua Arizona");
        Address ad3 = new Address(1520, null, "SP", "Sao Paulo", "Berrini", "Sem referências", "Av Berrini");
        addressRepository.saveAll(Arrays.asList(ad1, ad2, ad3));

        Beneficent beneficent1 = new Beneficent("Thales Oliveira",  (long) 119999,  "12345678", 300, "T-Thalles", formatter.parse("1985-05-05"), ad1);
        Beneficent beneficent2 = new Beneficent("Thauã Oliveira", (long) 219999, "123456789", 500, 500,  "Sr-Thauã", formatter.parse("1985-05-05"),ad2);
        Beneficent beneficent3 = new Beneficent("cauã Oliver", (long) 21666, "547474", 500, 500,  "Sr-cauã", formatter.parse("1985-05-05"),ad2);
        beneficentRepository.saveAll(Arrays.asList(beneficent1, beneficent2,beneficent3));

        Benefited benefited1 =  new Benefited("Joao Alves", (long)11921921, "394821911", 2, 3, "2020211", formatter.parse("1985-05-05"), ad3,ld);
        benefitedRepository.saveAll(Arrays.asList(benefited1));

        Glasses g1=new Glasses(150);
        Glasses g2=new Glasses(300);
        Glasses g3=new Glasses(600);
        ArrayList<Glasses> lg=new ArrayList<Glasses>();
        lg.add(g1);
        lg.add(g2);
        GlasseRepository.saveAll(Arrays.asList(g1,g2,g3));
        Donate do1=new Donate("12/5","150",beneficent1,d1,lg,lpy);
        DonateRepository.saveAll(Arrays.asList(do1));

    }
}