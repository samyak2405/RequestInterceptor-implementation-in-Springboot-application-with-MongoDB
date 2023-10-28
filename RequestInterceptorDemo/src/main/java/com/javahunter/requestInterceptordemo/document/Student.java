package com.javahunter.requestInterceptordemo.document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@SuperBuilder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collation = "student")
public class Student {

    @Id
    private String id;
    private String name;
    private String lastName;
    private int age;
    private String email;
}
