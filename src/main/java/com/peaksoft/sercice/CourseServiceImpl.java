package com.peaksoft.sercice;

import com.peaksoft.dao.CourseDao;
import com.peaksoft.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{

    private final  CourseDao courseDao;
@Autowired
    public CourseServiceImpl(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    @Override
    public List<Course> getAllCourses() {
        return courseDao.getAllCourse();
    }

    @Override
    public void addCourse(Course course, Long companyId) {
        courseDao.addCourse(course,companyId);
    }

    @Override
    public Course getCourseById(Long id) {
        return courseDao.getCourseById(id);
    }

    @Override
    public void updateCourse(Course course,Long id) {
    courseDao.updateCourse(course,id);

    }

    @Override
    public void deleteCourse(Course course) {
    courseDao.deleteCourse(course);
    }
}
