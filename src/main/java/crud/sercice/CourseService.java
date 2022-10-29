package crud.sercice;

import crud.entity.Course;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourses();
    void addCompany(Course course, String courseName);
    Course getCompanyById(long id);
    void updateCourse(Course course);
    void deleteCourse(Course course);

}
