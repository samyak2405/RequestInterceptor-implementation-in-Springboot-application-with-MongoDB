package com.javahunter.requestInterceptordemo.service;

import com.javahunter.requestInterceptordemo.document.Student;
import com.javahunter.requestInterceptordemo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;
    @Override
    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student findStudentById(String id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Student insertStudent(Student student) {
        return studentRepository.save(student);
    }
}
