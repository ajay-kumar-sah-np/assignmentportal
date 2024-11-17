package com.assignmentportal.repository;

import com.assignmentportal.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    User findByUsername(String username);

    User findByUsernameAndRole(String username,String role);

    List<User> findByRole(String role);

    Optional<User> findById(String userId);
}
