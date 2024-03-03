package com.akobir.eop.service.impl;

import com.akobir.eop.dto.UserRequestDTO;
import com.akobir.eop.entity.User;
import com.akobir.eop.event.UserCreatedEvent;
import com.akobir.eop.event.UserUpdatedEvent;
import com.akobir.eop.exception.NotFoundException;
import com.akobir.eop.mapper.UserMapper;
import com.akobir.eop.repository.UserRepository;
import com.akobir.eop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ApplicationEventPublisher eventPublisher;
    private final UserMapper userMapper;

    @Override
    public User createUser(UserRequestDTO dto) {
        User user = userMapper.toEntity(dto);
        User savedUser = userRepository.save(user);
        eventPublisher.publishEvent(new UserCreatedEvent(savedUser));
        return savedUser;
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found with id: " + id));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(Long userId, UserRequestDTO dto) {
        User existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("User not found with id: " + userId));

        User user = userMapper.toEntity(dto);
        user.setId(userId);
        user.setCreatedAt(existingUser.getCreatedAt());

        User updatedUser = userRepository.save(user);
        eventPublisher.publishEvent(new UserUpdatedEvent(updatedUser));

        return updatedUser;
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

}
