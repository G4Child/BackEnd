package com.Glasses4Child.project.repositories;

import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DependentRepositoryTest {

    @Autowired
    private BeneficentRepository beneficentRepository;
    @Autowired
    private LoginRepository loginRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Rule
    public ExpectedException thrown = ExpectedException.none();




}