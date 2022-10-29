package crud.controller;

import crud.entity.Company;
import crud.entity.Course;
import crud.sercice.CompanyService;
import crud.sercice.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/course")
public class CourseController {

    private CompanyService companyService;
    private final CourseService coursesService;

    @Autowired
    public CourseController(CompanyService companyService, CourseService coursesService) {
        this.companyService = companyService;
        this.coursesService = coursesService;
    }

    @ModelAttribute("companyList")
    public List<Company> getCompany(){
        return companyService.getAllCompanies();
    }

    @GetMapping()
    public String getCourses( Model model){
        model.addAttribute("courses",coursesService.getAllCourses());
        return "course/courses";

    }

    @GetMapping("/addCourse")
    public String addCource(Model model){
        model.addAttribute("course",new Course());
        return "course/addCourse";
    }

    @PostMapping("/saveCourse")
    public String saveCourse(@ModelAttribute("course") Course course){
        coursesService.addCompany(course,course.getCourseName());
        return "redirect:/courses";
    }

    @GetMapping("/updateCourse")
    public String updateCource(@RequestParam("Id") Long id, Model model){
        Course course =  coursesService.getCompanyById(id);
        model.addAttribute("course", course);
        return "course/updateCourse";
    }

    @PostMapping("/saveUpdateCourse")
    public String saveUpdateCourse(@RequestParam("companyId") Long id,@ModelAttribute("course") Course course){
        coursesService.updateCourse(course);
        return "redirect:/courses";
    }

    @DeleteMapping("/deleteCource")
    public String deleteCourse(@RequestParam("courseId") Long id, @RequestParam("companyId") Long id2){
        coursesService.deleteCourse(coursesService.getCompanyById(id));
        return "redirect:/courses";
    }
}
