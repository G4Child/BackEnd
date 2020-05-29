package com.Glass4Child.project.repositories;

import com.Glass4Child.project.entities.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login,Long> {
}
