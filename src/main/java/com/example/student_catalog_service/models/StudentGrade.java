package com.example.student_catalog_service.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentGrade {
    private String name;
    private int age;
    private int grade;
}