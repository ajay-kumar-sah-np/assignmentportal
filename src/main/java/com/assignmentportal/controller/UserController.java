package com.assignmentportal.controller;

import com.assignmentportal.model.User;
import com.assignmentportal.service.AssignmentService;
import com.assignmentportal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private AssignmentService assignmentService;

    @PostMapping(path = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        if(user.getUsername() == null || user.getPassword() == null || user.getRole() == null) {
            return ResponseEntity.status(400).body("Invalid credentials");
        }
        //username and userrole cannot be same for two users
        User foundUser = userService.findByUsernameAndRole(user.getUsername(), user.getRole());
        if (foundUser != null) {
            return ResponseEntity.status(400).body("user already exists");
        } else {
            userService.registerUser(user);
            return ResponseEntity.status(200).body("User registered successfully");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody User user) {
        if(user.getUsername() == null || user.getPassword() == null) {
            return ResponseEntity.status(400).body("Invalid credentials");
        }
        User foundUser = userService.findByUsername(user.getUsername());
        if(!userService.checkPassword(user.getPassword(), foundUser.getPassword())){
            return ResponseEntity.status(401).body("wrong password");
        }
        if (foundUser != null ) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }

    @GetMapping("/admins")
    public ResponseEntity<?> getAllAdmins(@RequestParam("username") String username) {
        User foundUser = userService.findByUsernameAndRole(username, "USER");
        if(foundUser == null || foundUser.getRole().equalsIgnoreCase("ADMIN")) {
            return ResponseEntity.status(400).body("Only users can see admins");
        }
        List<User> admins = userService.findAllAdmins();
        return ResponseEntity.ok(admins);
    }
}
