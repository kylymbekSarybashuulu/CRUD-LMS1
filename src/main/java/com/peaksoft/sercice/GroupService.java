package com.peaksoft.sercice;

import com.peaksoft.entity.Group;

import java.util.List;

public interface GroupService {
    List<Group> getAllGroup();
    void addGroup(Group group);
    Group getGroupById(Long id);
    void deleteGroup(Group group);
    void updateGroup(Group group,Long id);


}
