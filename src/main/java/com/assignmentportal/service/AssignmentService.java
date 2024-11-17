package com.assignmentportal.service;

import com.assignmentportal.model.Assignment;
import com.assignmentportal.repository.AssignmentRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AssignmentService {
    @Autowired
    private AssignmentRepository assignmentRepository;

    @Autowired
    Gson gson;

    public Assignment uploadAssignment(Assignment assignment) {
        assignment.setTimestamp(LocalDateTime.now());
        assignment.setStatus("PENDING");
        return assignmentRepository.save(assignment);
    }

    public ResponseEntity<?> getAssignmentsByAdmin(String admin) {
        List<Assignment> list=  assignmentRepository.findByAdmin(admin);
        if(CollectionUtils.isEmpty(list)){
            return ResponseEntity.status(204).body("No assignments found");
        }
        return ResponseEntity.status(200).body(gson.toJson(list));
    }


    public ResponseEntity<?> acceptAssignment(String id) {
        Optional<Assignment> assignmentOptional = assignmentRepository.findById(id);
        if (assignmentOptional.isEmpty()) {
            return ResponseEntity.status(204).body("Assignment not found");
        } else {
            Assignment assignment = assignmentOptional.get();
            assignment.setStatus("ACCEPTED");
            assignmentRepository.save(assignment);
            return ResponseEntity.status(200).body("Accepted");
        }
    }

    public ResponseEntity<?> rejectAssignment(String id) {

        Optional<Assignment> assignmentOptional = assignmentRepository.findById(id);
        if (assignmentOptional.isEmpty()) {
            return ResponseEntity.status(204).body("Assignment not found");
        } else {
            Assignment assignment = assignmentOptional.get();
            assignment.setStatus("REJECTED");            assignmentRepository.save(assignment);
            return ResponseEntity.status(200).body("Accepted");
        }
    }
}