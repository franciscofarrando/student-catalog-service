package com.example.student_catalog_service.controllers;

import com.example.student_catalog_service.client.GradeClient;
import com.example.student_catalog_service.client.StudentClient;
import com.example.student_catalog_service.dto.CourseDTO;
import com.example.student_catalog_service.dto.CourseGradeDTO;
import com.example.student_catalog_service.dto.StudentInfoDTO;
import com.example.student_catalog_service.models.Catalog;
import com.example.student_catalog_service.models.StudentGrade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/catalog")
public class CatalogController {
    @Autowired
    GradeClient gradeClient;

    @Autowired
    StudentClient studentClient;

    @GetMapping("/{courseCode}")
    @ResponseStatus(HttpStatus.OK)
    public Catalog getCatalogInfo(@PathVariable Long courseCode) {

        CourseDTO course = gradeClient.getCourse(courseCode);
        if (course == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Course not found");
        }
        List<CourseGradeDTO> grades= gradeClient.getGradesByCourse(courseCode);

        List<StudentGrade> studentsGrades = new ArrayList<>();

        for(CourseGradeDTO grade : grades) {

            StudentInfoDTO student = studentClient.getStudentById(grade.getStudentId());
            if (student == null) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found");
            }
            studentsGrades.add(new StudentGrade(student.getName(), student.getAge(), grade.getGrade()));
        }

        return new Catalog(course.getName(), studentsGrades);
    }
}
