package com.microservices.DepartmentService.service;

import com.microservices.DepartmentService.entity.Department;
import com.microservices.DepartmentService.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);

    }

    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id).get();
    }
}
