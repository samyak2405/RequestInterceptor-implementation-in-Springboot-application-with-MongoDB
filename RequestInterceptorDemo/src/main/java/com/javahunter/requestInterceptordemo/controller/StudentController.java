package com.javahunter.requestInterceptordemo.controller;

import com.javahunter.requestInterceptordemo.dto.StudentDto;
import com.javahunter.requestInterceptordemo.mapper.StudentMapper;
import com.javahunter.requestInterceptordemo.service.StudentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
@Slf4j
public class StudentController {

    private final StudentService studentService;
    private final StudentMapper studentMapper;

    //Not working
    @GetMapping("/student/all")
    public List<StudentDto> findAllStudent(){
        log.info("Find all students - controller method");
        List<StudentDto> studentDtos = new ArrayList<>();
        studentService.findAllStudents().forEach(student -> studentDtos.add(studentMapper.fromStudent(student)));
        return studentDtos;
    }

    @GetMapping("/student/id/{id}")
    public ResponseEntity<StudentDto> findByStudentId(@PathVariable String id){
        var student = studentService.findStudentById(id);
        if(student==null)
            return ResponseEntity.notFound().build();
        var foundStudent = studentMapper.fromStudent(student);
        return ResponseEntity.ok().body(foundStudent);
    }

    @PostMapping("/student")
    public ResponseEntity<StudentDto> insertStudent(@RequestBody StudentDto studentDto){
        var studentToInsert = studentMapper.toStudent(studentDto);
        var insertedStudent = studentService.insertStudent(studentToInsert);
        var insertedStudentDto = studentMapper.fromStudent(insertedStudent);
        return ResponseEntity.ok().body(insertedStudentDto);
    }
}
