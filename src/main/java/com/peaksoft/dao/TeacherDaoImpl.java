package com.peaksoft.dao;

import com.peaksoft.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Comparator;
import java.util.List;
@Repository
@Transactional
public class TeacherDaoImpl implements TeacherDao{

    @PersistenceContext
    EntityManager entityManager;

    private final CourseDao courseDao;

    @Autowired
    public TeacherDaoImpl(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    @Override
    public List<Teacher> getAllTeachers() {
        List<Teacher>teachers=entityManager.createQuery("from Teacher",Teacher.class).getResultList();
        Comparator<Teacher>comparator=((o1, o2) -> (int) (o1.getId()- o2.getId()) );
        teachers.sort(comparator);
        return teachers;
    }
    @Override
    public void addTeacher(Teacher teacher) {
        entityManager.merge(teacher);
    }

    @Override
    public Teacher getTeacherById(Long id) {
        return entityManager.find(Teacher.class,id);
    }

    @Override
    public void deleteTeacher(Teacher teacher) {
        entityManager.remove(entityManager.contains(teacher) ? teacher:entityManager.merge(teacher));
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        entityManager.merge(teacher);
    }
}
