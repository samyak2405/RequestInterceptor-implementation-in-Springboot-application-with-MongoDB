package com.javahunter.requestInterceptordemo.mapper;

import com.javahunter.requestInterceptordemo.document.Student;
import com.javahunter.requestInterceptordemo.dto.StudentDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    Student toStudent(StudentDto studentDto);
    StudentDto fromStudent(Student student);
}
