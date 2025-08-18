package com.akshay.spring.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.akshay.spring.entities.Teacher;

public interface TeacherService {

    Teacher save(Teacher teacher);

    Page<Teacher> findAllTeachers(Pageable pageable);

    Teacher updateTeacherById(Long id, Teacher teacher);

    long countTeachers();

    void deleteTeacher(Long id);

    Teacher getTeacherById(Long id);
}
