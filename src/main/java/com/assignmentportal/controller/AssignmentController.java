package com.assignmentportal.controller;

import com.assignmentportal.model.Assignment;
import com.assignmentportal.model.User;
import com.assignmentportal.service.AssignmentService;
import com.assignmentportal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/assignments")
public class AssignmentController {
    @Autowired
    private AssignmentService assignmentService;
    @Autowired
    private UserService userService;
    @PostMapping("/upload")
    public ResponseEntity<?> uploadAssignment(@RequestBody Assignment assignment) {
        Optional<User> foundUser = userService.findByUserId(assignment.getUserId());
        if (foundUser.isEmpty() || foundUser.get().getRole().equalsIgnoreCase("ADMIN")) {
            return ResponseEntity.status(400).body("Only students can upload assignments");
        }
        User admin = userService.findByUsernameAndRole(assignment.getAdmin(), "ADMIN");
        if (ObjectUtils.isEmpty(admin)) {
            return ResponseEntity.status(400).body("Admin not found");
        }
        assignment.setUserId(foundUser.get().getId());
        return ResponseEntity.ok(assignmentService.uploadAssignment(assignment));
    }

    @GetMapping("/admin/{admin}")
    public ResponseEntity<?> getAssignmentsByAdmin(@PathVariable String admin) {
        if(StringUtils.isEmpty(admin)) {
            return ResponseEntity.status(400).body("Assignment id is required");
        }
        return assignmentService.getAssignmentsByAdmin(admin);
    }

    @PostMapping("/{id}/accept")
    public ResponseEntity<?> acceptAssignment(@PathVariable String id) {
        if(StringUtils.isEmpty(id)) {
            return ResponseEntity.status(400).body("Assignment id is required");
        }
        return assignmentService.acceptAssignment(id);
    }

    @PostMapping("/{id}/reject")
    public ResponseEntity<?> rejectAssignment(@PathVariable String id) {
        if(StringUtils.isEmpty(id)) {
            return ResponseEntity.status(400).body("Assignment id is required");
        }
        return assignmentService.rejectAssignment(id);
    }
}