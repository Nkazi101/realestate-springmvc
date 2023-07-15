package com.realestate.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.realestate.model.Property;
import com.realestate.model.User;
import com.realestate.repo.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User save(User user) throws Exception {
        return userRepository.save(user);
    }

    public User signIn(User user) throws Exception {
        User foundUser = userRepository.findByEmail(user.getEmail());

        if (foundUser == null) {
            throw new Exception("User not found");
        }

        if (!foundUser.getPassword().equals(user.getPassword())) {
            throw new Exception("Invalid credentials");
        }

        return foundUser;
    }

    public User findById(Long id) throws Exception {
        Optional<User> user = userRepository.findById(id);

        if (user.isPresent()) {
            return user.get();
        } else {
            throw new Exception("User not found");
        }
    }

    public User findByEmail(String email) throws Exception {
        User user = userRepository.findByEmail(email);

        if (user == null) {
            throw new Exception("User not found");
        }

        return user;
    }

    public List<User> findAll() throws Exception {
        return userRepository.findAll();
    }

    public User update(User user) throws Exception {
        return userRepository.save(user);
    }

    public void deleteById(Long id) throws Exception {
        userRepository.deleteById(id);
    }

    public List<Property> getUserProperties(Long userId) {
        Optional<User> user = userRepository.findById(userId);

        if (user.isPresent()) {
            return user.get().getUserProperties();
        } else {
            throw new RuntimeException("User not found");
        }
    }
}

