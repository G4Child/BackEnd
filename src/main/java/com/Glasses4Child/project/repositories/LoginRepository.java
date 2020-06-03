package com.Glasses4Child.project.repositories;

import com.Glasses4Child.project.entities.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login,Long> {
    Login findByEmail(String email);
}
