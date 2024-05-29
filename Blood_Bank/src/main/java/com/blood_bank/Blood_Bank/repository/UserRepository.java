package com.blood_bank.Blood_Bank.repository;


import com.blood_bank.Blood_Bank.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
