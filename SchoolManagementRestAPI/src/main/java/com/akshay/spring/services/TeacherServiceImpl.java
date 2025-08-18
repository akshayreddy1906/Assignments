package com.akshay.spring.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import com.akshay.spring.entities.Teacher;
import com.akshay.spring.repositories.TeacherRepository;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    @Override
    public Teacher save(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public Page<Teacher> findAllTeachers(Pageable pageable) {
        return teacherRepository.findAll(pageable);
    }

    @Override
    public Teacher updateTeacherById(Long id, Teacher teacher) {
        Teacher existingTeacher = teacherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Teacher not found with id: " + id));

        if (teacher.getTeacherName() != null) {
            existingTeacher.setTeacherName(teacher.getTeacherName());
        }
        if (teacher.getTeacherAddress() != null) {
            existingTeacher.setTeacherAddress(teacher.getTeacherAddress());
        }
        if (teacher.getQualification() != null) {
            existingTeacher.setQualification(teacher.getQualification());
        }
        if (teacher.getAge() != 0) {
            existingTeacher.setAge(teacher.getAge());
        }
        if (teacher.getDob() != null) {
            existingTeacher.setDob(teacher.getDob());
        }
        if (teacher.getExperience() != 0) {
            existingTeacher.setExperience(teacher.getExperience());
        }

        return teacherRepository.save(existingTeacher);
    }

    @Override
    public long countTeachers() {
        return teacherRepository.count();
    }

    @Override
    public void deleteTeacher(Long id) {
        if (!teacherRepository.existsById(id)) {
            throw new RuntimeException("Teacher not found with id: " + id);
        }
        teacherRepository.deleteById(id);
    }

    @Override
    public Teacher getTeacherById(Long id) {
        return teacherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Teacher not found with id: " + id));
    }
}
