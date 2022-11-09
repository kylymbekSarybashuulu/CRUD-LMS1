package com.peaksoft.sercice;

import com.peaksoft.dao.TeacherDao;
import com.peaksoft.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherDao teacherDao;

    @Autowired
    public TeacherServiceImpl(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherDao.getAllTeachers();
    }

    @Override
    public void addTeacher(Teacher teacher, Long courseId) {
        teacherDao.addTeacher(teacher);
    }

    @Override
    public Teacher getTeacherById(Long id) {
        return teacherDao.getTeacherById(id);
    }

    @Override
    public void deleteTeacher(Teacher teacher) {
        teacherDao.deleteTeacher(teacher);
    }

    @Override
    public void updateTeacher(Teacher teacher, Long courseId) {
        teacherDao.updateTeacher(teacher.getCourse().getTeacher());
    }
}
