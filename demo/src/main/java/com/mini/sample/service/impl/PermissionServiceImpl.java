package com.mini.sample.service.impl;

import com.mini.framework.orm.DataSet;
import com.mini.framework.tx.annotation.Service;
import com.mini.sample.entity.Permission;
import com.mini.sample.service.PermissionService;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Override
    public List<Permission> getPermissionList() {
        return DataSet.selectList(Permission.class);
    }
}
