package com.assignmentportal.service;

import com.assignmentportal.model.User;
import com.assignmentportal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User registerUser(User user) {
//        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User findByUsernameAndRole(String username,String role) {
        return userRepository.findByUsernameAndRole(username, role);
    }
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public boolean checkPassword(String rawPassword, String encodedPassword) {
//        return bCryptPasswordEncoder.matches(rawPassword, encodedPassword);
        return rawPassword.equals(encodedPassword);
    }

    public List<User> findAllAdmins() {
        return userRepository.findByRole("ADMIN");
    }

    public Optional<User> findByUserId(String userId) {
        return userRepository.findById(userId);
    }
}
