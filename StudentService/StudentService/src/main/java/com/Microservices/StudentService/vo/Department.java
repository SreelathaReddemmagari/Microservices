package com.Microservices.StudentService.vo;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Department {
    private String deptName;
    private String deptAddress;
    private String deptCode;
}