package com.assignmentportal.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "assignments")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Assignment {
    @Id
    private String id;
    private String userId;
    private String task;
    private String admin;
    private LocalDateTime timestamp;
    private String status; // "PENDING", "ACCEPTED", "REJECTED"
}