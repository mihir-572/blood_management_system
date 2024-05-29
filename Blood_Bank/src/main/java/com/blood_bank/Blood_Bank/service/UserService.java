package com.blood_bank.Blood_Bank.service;

import com.blood_bank.Blood_Bank.Entities.User;
import com.blood_bank.Blood_Bank.dto.UserDto;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findByEmail(String email);

    List<UserDto> findAllUsers();
}
