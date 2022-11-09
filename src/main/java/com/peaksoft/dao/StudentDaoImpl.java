package com.peaksoft.dao;

import com.peaksoft.entity.Group;
import com.peaksoft.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Comparator;
import java.util.List;

@Repository
@Transactional
public class StudentDaoImpl implements StudentDao{
    private final GroupDao groupDao;
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    public StudentDaoImpl(GroupDao groupDao) {
        this.groupDao = groupDao;
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> students = entityManager.createQuery("from Student", Student.class).getResultList();
        Comparator<Student> comparator=((o1, o2) ->(int)(o1.getId()-o2.getId()));
        students.sort(comparator);
        return students;
    }

    @Override
    public void addStudent(Student student,Long groupId) {
        Group group = groupDao.getGroupById(groupId);
        student.setGroups(group);
        entityManager.persist(student);
    }

    @Override
    public Student getStudentById(Long id) {
        Student student = entityManager.find(Student.class,id);
        return student;
    }

    @Override
    public void updateStudent(Student student,Long groupId) {
        Group group = groupDao.getGroupById(groupId);
        student.setGroups(group);
        entityManager.merge(student);
    }

    @Override
    public void deleteStudent(Student student) {
        entityManager.remove(entityManager.contains(student)?student:entityManager.merge(student));
    }
}
