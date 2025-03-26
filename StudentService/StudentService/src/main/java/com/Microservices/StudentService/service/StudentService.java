package com.Microservices.StudentService.service;

import com.Microservices.StudentService.entity.Student;
import com.Microservices.StudentService.exception.StudentNotFoundException;
import com.Microservices.StudentService.repository.StudentRepository;
import com.Microservices.StudentService.vo.Department;
import com.Microservices.StudentService.vo.StudentDepartmentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StudentService {


    //private String baseUrl = "http://localhost:8080/department/";
    private String baseUrl = "http://DEPARTMENTSERVICE/department/";

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private MailService mailService;

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

   public String getStudentWithDepartment(Long id){
        Student student=studentRepository.findById(id).get();
       System.out.println("Department value: " + student.getDepartmentId());
       String url = baseUrl + student.getDepartmentId();
       System.out.println("Requesting department from: " + url);
       Department department = restTemplate.getForObject(baseUrl+student.getDepartmentId(), Department.class);
       System.out.println("Department value: " + department);
       if (department == null) {
           System.out.println("Department not found for deptId: " + student.getDepartmentId());
       }
//       StudentDepartmentVo studentDepartmentVo=new StudentDepartmentVo();
//       studentDepartmentVo.setDepartment(department);
//       studentDepartmentVo.setStudent(student);
//       return studentDepartmentVo;
       StringBuffer stringBuffer=new StringBuffer();
       stringBuffer.append("please find below");
       stringBuffer.append("\n");
       stringBuffer.append(student.getStudentId()+" "+student.getFirstName()+" "+student.getLastName()+" "+student.getEmail());
       stringBuffer.append("\n");
       stringBuffer.append(department.getDeptName()+" "+department.getDeptAddress()+" "+department.getDeptCode());
       mailService.sendMail("naveenkap17@gmail.com","Student with department details",stringBuffer.toString());
       return "student details with deparment details are send to your mail";


   }
}
