package com.akshay.spring.controller;

import com.akshay.spring.entitites.Student;
import com.akshay.spring.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public String viewHome(Model model) {
        model.addAttribute("list", studentService.getAllStudents());
        model.addAttribute("student", new Student());
        return "index";
    }

    @PostMapping("/save")
    public String saveStudent(@ModelAttribute Student student) {
        studentService.saveStudent(student);
        return "redirect:/";
    }

    @GetMapping("/edit/{rollNo}")
    public String showEdit(@PathVariable Long rollNo, Model model) {
        Student student = studentService.getStudentByRollNo(rollNo);
        model.addAttribute("student", student);
        return "edit";
    }

    @PostMapping("/update")
    public String updateStudent(@ModelAttribute Student student) {
        studentService.saveStudent(student);
        return "redirect:/";
    }

    @GetMapping("/delete/{rollNo}")
    public String deleteStudent(@PathVariable Long rollNo) {
        studentService.deleteStudent(rollNo);
        return "redirect:/";
    }
}

