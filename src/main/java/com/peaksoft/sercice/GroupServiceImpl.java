package com.peaksoft.sercice;

import com.peaksoft.dao.GroupDao;
import com.peaksoft.entity.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GroupServiceImpl implements GroupService{

    private final GroupDao groupDao;

    @Autowired
    public GroupServiceImpl(GroupDao groupDao) {
        this.groupDao = groupDao;
    }


    @Override
    public List<Group> getAllGroup() {
        return groupDao.getAllGroup();
    }

    @Override
    public void addGroup(Group group) {
        groupDao.addGroup(group);
    }

    @Override
    public Group getGroupById(Long id) {
        return groupDao.getGroupById(id);
    }

    @Override
    public void deleteGroup(Group group) {
        groupDao.deleteGroup(group);
    }

    @Override
    public void updateGroup(Group group, Long id) {
        groupDao.updateGroup(group,id);
    }
}
