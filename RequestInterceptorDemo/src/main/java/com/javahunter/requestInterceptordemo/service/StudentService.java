package com.javahunter.requestInterceptordemo.service;

import com.javahunter.requestInterceptordemo.document.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    List<Student> findAllStudents();
    Student findStudentById(String id);
    Student insertStudent(Student student);
}
