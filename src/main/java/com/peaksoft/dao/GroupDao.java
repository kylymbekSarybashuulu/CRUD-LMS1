package com.peaksoft.dao;

import com.peaksoft.entity.Group;

import java.util.List;

public interface GroupDao {
    List<Group> getAllGroup();
    void addGroup(Group group);
    Group getGroupById(Long id);
    void updateGroup(Group group,Long id);
    void deleteGroup(Group group);


}
