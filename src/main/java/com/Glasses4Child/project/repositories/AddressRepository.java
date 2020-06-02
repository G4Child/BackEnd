package com.Glasses4Child.project.repositories;

import com.Glasses4Child.project.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}