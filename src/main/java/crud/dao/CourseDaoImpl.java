package crud.dao;

import crud.entity.Company;
import crud.entity.Course;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class CourseDaoImpl implements CourseDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Course> getAllCourse() {
        return null;
    }

    @Override
    public void addCompany(Course course) {
        entityManager.persist(course);
    }

    @Override
    public Course getCompanyById(long id) {
        entityManager.find(Company.class,id);
        return null;
    }

    @Override
    public void updateCompany(Course course) {
        entityManager.merge(course);
    }

    @Override
    public void deleteCompany(Course course) {
        entityManager.remove(entityManager.contains(course) ? course : entityManager.merge(course));
    }
}
