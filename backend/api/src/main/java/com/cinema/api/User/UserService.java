package com.cinema.api.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> insertAll(List<User> users) {
        return userRepository.insert(users);
    }

    public User insert(User user) {
        return userRepository.findByLogin(user.getLogin()).orElse(userRepository.insert(user));
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(String userId) {
        return userRepository.findByUserId(userId);
    }
}
