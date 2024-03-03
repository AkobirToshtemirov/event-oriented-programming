package com.akobir.eop.service;

import com.akobir.eop.dto.UserRequestDTO;
import com.akobir.eop.entity.User;

import java.util.List;

public interface UserService {
    User createUser(UserRequestDTO dto);

    User getUserById(Long id);

    List<User> getAllUsers();

    User updateUser(Long userId, UserRequestDTO dto);

    void deleteUserById(Long id);
}
