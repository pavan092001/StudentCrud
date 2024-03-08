package com.example.service;


import com.example.model.Student;
import com.example.request.StudentRequest;
import org.springframework.stereotype.Service;

import java.util.List;


public interface StudentService {


    public Student createStudent(Student student);

    public Student findStudentByStudentId(Integer id) throws Exception;
    public Student updateStudentId(Integer id, StudentRequest student) throws Exception;

    public void deleteStudent(Integer id) throws Exception;
    public List<Student> getAllStudent();

}
