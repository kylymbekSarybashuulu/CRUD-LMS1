package com.peaksoft.controller;

import com.peaksoft.entity.Course;
import com.peaksoft.entity.Teacher;
import com.peaksoft.sercice.CourseService;
import com.peaksoft.sercice.GroupService;
import com.peaksoft.sercice.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/teachers")
public class TeacherController {

    private final TeacherService teacherService;

    private final CourseService courseService;

    @Autowired
    public TeacherController(TeacherService teacherService, GroupService groupService, CourseService courseService) {
        this.teacherService = teacherService;
        this.courseService = courseService;
    }

    @ModelAttribute("courseList")
    public List<Course> findAllTeachers(){
        return courseService.getAllCourses();
    }
    @ModelAttribute("/TeacherList")
    public List<Teacher> findAllTeacher(){
        return teacherService.getAllTeachers();
    }

    @GetMapping()
    public String getAllTeacher( Model model){
        List<Teacher> teachers = teacherService.getAllTeachers();
        model.addAttribute("teachers",teachers);
        return "teacher/teachers";
    }

    @GetMapping("/addTeacher")
    public String addTeacher(Model model){
        model.addAttribute("teacher",new Teacher());
        return "teacher/addTeacher";
    }

    @PostMapping("/saveTeacher")
    public String saveCourse(@ModelAttribute("teacher") Teacher teacher){
        teacherService.addTeacher(teacher,teacher.getCourse().getId());
        return "redirect:/teachers";
    }

    @GetMapping("/{id}/updateTeacher")
    public String updateTeacher(@PathVariable("id") Long id, Model model){
        Teacher teacher =  teacherService.getTeacherById(id);
        model.addAttribute("teacher", teacher);
        return "teacher/updateTeacher";
    }

    @PostMapping("/saveUpdateTeacher")
    public String saveUpdateTeacher(@PathVariable("teacher") Long id,@ModelAttribute("teacher")Teacher teacher){
        teacherService.updateTeacher(teacher,teacher.getCourseId());
        return "redirect:/teachers";
    }

    @DeleteMapping("/deleteTeacher/{id}")
    public String deleteCourse(@PathVariable("id") Long id){
        teacherService.deleteTeacher(teacherService.getTeacherById(id));
        return "redirect:/teachers";
    }
}
