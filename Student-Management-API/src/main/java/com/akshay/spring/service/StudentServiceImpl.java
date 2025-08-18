package com.akshay.spring.service;

import com.akshay.spring.entitites.Student;
import com.akshay.spring.repositories.StudentRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

     public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentByRollNo(long rollNo) {
        return studentRepository.findById(rollNo).orElse(null);
    }


    @Override
    public void deleteStudent(long rollNo) {
        studentRepository.deleteById(rollNo);
    }
}



























//@Override
//public Student updateStudent(long rollNo, Student student) {
//  Optional<Student> existing = studentRepository.findById(rollNo);
//  if (existing.isPresent()) {
//      Student dbStudent = existing.get();
//      dbStudent.setName(student.getName());
//      dbStudent.setAge(student.getAge());
//      dbStudent.setEmail(student.getEmail());
//      dbStudent.setDob(student.getDob());
//      return studentRepository.save(dbStudent);
//  } else {
//      return null; //
//  }
//}