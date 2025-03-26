package com.microservices.DepartmentService.controller;

import com.microservices.DepartmentService.entity.Department;
import com.microservices.DepartmentService.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/department")

public class DepartmentController {


        @Autowired
        private DepartmentService departmentService;
        @PostMapping("/save")
        public Department SaveDepartment(@RequestBody Department department){
            return departmentService.saveDepartment(department);
        }
        @GetMapping("/{id}")
        public Department getDepartmentById(@PathVariable Long id){
            return departmentService.getDepartmentById(id);
        }


}
