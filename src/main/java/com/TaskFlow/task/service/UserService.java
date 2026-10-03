package com.TaskFlow.task.service;

import com.TaskFlow.task.entities.User;
import com.TaskFlow.task.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return userRepository.save(new User());
    }

    public Optional<User> readUser(Integer id) {
        return userRepository.findById(id);
    }

    public void updateUser(Integer id, User user) {
        if (userRepository.findById(user.getId()).isPresent()) {
            user.setId(id);
            userRepository.save(user);
        }
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    public List<User> listUser() {
        return userRepository.findAll();
    }
}
