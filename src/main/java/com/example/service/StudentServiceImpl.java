package com.example.service;

import com.example.Repository.StudentRepository;
import com.example.model.Student;
import com.example.request.StudentRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class StudentServiceImpl implements StudentService {


    @Autowired
    private StudentRepository studentRepository;
    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student) ;
    }

    @Override
    public Student findStudentByStudentId(Integer id) throws Exception {
        Optional<Student> studentOptional = studentRepository.findById(id);
        if(studentOptional.isEmpty())
            throw  new Exception("Student not found with given ID");

        return studentOptional.get();

    }

    @Override
    public Student updateStudentId(Integer id, StudentRequest updateStudent) throws Exception {
        Student student = findStudentByStudentId(id);
        BeanUtils.copyProperties(updateStudent,student);
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Integer id) throws Exception {
        Student student = findStudentByStudentId(id);
        studentRepository.delete(student);
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }
}
