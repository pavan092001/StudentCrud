package com.example.Controller;


import com.example.model.Student;
import com.example.request.StudentRequest;
import com.example.response.DeleteResponse;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {




    @Autowired
    private StudentService studentService;


    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        Student savedStudent = studentService.createStudent(student);
        return  new ResponseEntity<>(savedStudent, HttpStatus.CREATED);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Integer id) throws Exception {
        Student student = studentService.findStudentByStudentId(id);
        return  new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Integer id,@RequestBody StudentRequest studentReq) throws Exception {
        System.out.println(studentReq);
        Student student = studentService.updateStudentId(id,studentReq);
        return  new ResponseEntity<>(student, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteResponse>deleteStudent(@PathVariable Integer id) throws Exception {
        studentService.deleteStudent(id);
        DeleteResponse deleteResponse = new DeleteResponse();
        deleteResponse.setMessage("Student with id-> "+id+" Deleted Successfully");
        return  new ResponseEntity<>(deleteResponse, HttpStatus.OK);
    }

    @GetMapping("/allStudents")
    public ResponseEntity<List<Student>> getAllStudent() throws Exception {
        List<Student> student = studentService.getAllStudent();
        return  new ResponseEntity<>(student, HttpStatus.OK);
    }


}
