package crud.sercice;

import crud.dao.CourseDao;
import crud.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{

    private final CourseDao courseDao;
    @Autowired
    public CourseServiceImpl(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    @Override
    public List<Course> getAllCourses() {
        return courseDao.getAllCourse();
    }

    @Override
    public void addCompany(Course course, String courseName) {
    courseDao.addCompany(course);
    }

    @Override
    public Course getCompanyById(long id) {
        return courseDao.getCompanyById(id);
    }

    @Override
    public void updateCourse(Course course) {
    courseDao.updateCompany(course);
    }

    @Override
    public void deleteCourse(Course course) {
    courseDao.deleteCompany(course);
    }
}
