package com.Microservices.StudentService.vo;

import com.Microservices.StudentService.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDepartmentVo {
    private Student student;
    private Department department;
}
