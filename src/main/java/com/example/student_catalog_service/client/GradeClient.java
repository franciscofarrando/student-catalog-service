package com.example.student_catalog_service.client;

import com.example.student_catalog_service.dto.CourseDTO;
import com.example.student_catalog_service.dto.CourseGradeDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "grades-data-service")
public interface GradeClient {
    @GetMapping("/api/grades/{courseCode}")
    List<CourseGradeDTO> getGradesByCourse(@PathVariable Long courseCode);

    @GetMapping("/api/courses/{courseCode}")
    CourseDTO getCourse(@PathVariable Long courseCode);
}
