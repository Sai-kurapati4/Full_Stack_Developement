package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;

@Controller
@RequestMapping("/students")
public class StudentController {

 private final StudentRepository repo;

 public StudentController(StudentRepository repo){
  this.repo=repo;
 }

 @GetMapping
 public String listStudents(Model model){
  List<Student> students=repo.findAll();
  model.addAttribute("students",students);
  return "students/list";
 }

 @GetMapping("/new")
 public String showForm(Model model){
  model.addAttribute("student",new Student());
  return "students/form";
 }

 @PostMapping("/save")
 public String saveStudent(@ModelAttribute Student student){
  repo.save(student);
  return "redirect:/students";
 }
}