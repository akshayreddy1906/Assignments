package com.akshay.spring.service;

import com.akshay.spring.entitites.Student;
import java.util.List;

public interface StudentService {
    public Student saveStudent(Student student);
    public List<Student> getAllStudents();
    public Student getStudentByRollNo(long rollNo);
    public void deleteStudent(long rollNo);
}
