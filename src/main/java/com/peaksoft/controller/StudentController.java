package com.peaksoft.controller;

import com.peaksoft.entity.Group;
import com.peaksoft.entity.Student;
import com.peaksoft.sercice.GroupService;
import com.peaksoft.sercice.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;
    private final GroupService groupService;

    @Autowired
    public StudentController(StudentService studentService, GroupService groupService) {
        this.studentService = studentService;
        this.groupService = groupService;
    }
    @ModelAttribute("groupList")
    public List<Group> getAllGroup(){
        return groupService.getAllGroup();
    }

    @GetMapping
    public String getAllStudent(Model model){
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students",students);
        return "student/students";
    }
    @GetMapping("/addStudent")
    public String addStudent(Model model){
        model.addAttribute("student",new Student());
        return "student/addStudent";
    }

    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute("student") Student student){
        studentService.addStudent(student,student.getGroupsId());
        return "redirect:/students";
    }
    @GetMapping("/updateStudent/{id}")
    public String updateStudent(@PathVariable Long id, Model model){
        Student student = studentService.getStudentById(id);
        model.addAttribute("student",student);
        return "student/updateStudent";
    }
    @PatchMapping("/saveUpdateStudent")
    public String saveUpdateStudent(@ModelAttribute("student")Student student){
        studentService.updateStudent(student,student.getGroupsId());
        return "redirect:/students";
    }

    @DeleteMapping("/deleteStudent")
    public String deleteStudent(@RequestParam("studentId") Long id){
        studentService.deleteStudent(studentService.getStudentById(id));
        return "redirect:/students";
    }
}
