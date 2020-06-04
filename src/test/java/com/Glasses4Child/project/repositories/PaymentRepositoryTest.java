package com.Glasses4Child.project.repositories;

import com.Glasses4Child.project.entities.Payment;
import com.Glasses4Child.project.entities.Record;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase
class PaymentRepositoryTest {

    @Autowired
    PaymentRepository paymentRepository;
    @Autowired
    RecordRepository recordRepository;
    @Autowired
    DonationRepository donationRepository;
    @Autowired
    GlassesRepository glassesRepository;

    @Test
    public void mustPersistPaymentData() {
        Record record = new Record("STARTED", donationRepository.findById(1L).get(), glassesRepository.findById(1L).get());
        recordRepository.save(record);

        ArrayList<Record> recordsList = new ArrayList<>();
        recordsList.add(record);

        Payment payment = new Payment("SLIP", 100.0, recordsList);
        paymentRepository.save(payment);

        Assertions.assertEquals(payment.getPaymentMethod(), paymentRepository.findById(payment.getId()).get().getPaymentMethod());
    }
}