package com.example.student_catalog_service.client;

import com.example.student_catalog_service.dto.StudentInfoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "students-info-service")
public interface StudentClient {
    @GetMapping("/api/students/{id}")
    StudentInfoDTO getStudentById(@PathVariable Long id);
}