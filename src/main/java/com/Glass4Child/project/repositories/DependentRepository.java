package com.Glass4Child.project.repositories;

import com.Glass4Child.project.entities.Address;
import com.Glass4Child.project.entities.Dependent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DependentRepository  extends JpaRepository<Dependent, Long> {

}
