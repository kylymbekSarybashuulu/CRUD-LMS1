package crud.dao;

import crud.entity.Course;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CourseDao {
    List<Course> getAllCourse();
    void addCompany(Course course);
    Course getCompanyById(long id);
    void updateCompany(Course course);
    void deleteCompany(Course course);
}
