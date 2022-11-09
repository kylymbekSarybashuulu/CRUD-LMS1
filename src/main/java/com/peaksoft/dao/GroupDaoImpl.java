package com.peaksoft.dao;

import com.peaksoft.entity.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.JoinColumn;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Comparator;
import java.util.List;
@Repository
@Transactional
public class GroupDaoImpl implements GroupDao{
    @PersistenceContext
    EntityManager entityManager;

    private final CourseDao courseDao;

    @Autowired
    public GroupDaoImpl(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    @Override
    public List<Group> getAllGroup() {
        List<Group> groups = entityManager.createQuery("FROM Group",Group.class).getResultList();
        Comparator<Group> comparator=((o1, o2) -> (int)(o1.getId() - o2.getId()));
        groups.sort(comparator);
        return groups;
    }

    @Override
    public void addGroup(Group group) {
        entityManager.persist(group);
    }

    @Override
    public Group getGroupById(Long id) {
        return entityManager.find(Group.class,id);
    }


@Override
    public void updateGroup(Group group,Long id) {
        Group group1 = getGroupById(id);
        group1.setGroupName(group.getGroupName());
        group1.setDateOfCreate(group.getDateOfCreate());
        group1.setDateOfFinish(group.getDateOfFinish());
        entityManager.merge(group1);
    }

    @Override
    public void deleteGroup(Group group) {
        entityManager.remove(entityManager.contains(group));
    }
}
