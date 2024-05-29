package com.blood_bank.Blood_Bank.repository;

import com.blood_bank.Blood_Bank.Entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
