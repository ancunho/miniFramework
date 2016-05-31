package com.mini.sample.service.impl;

import com.mini.framework.annotation.Service;
import com.mini.sample.entity.Role;
import com.mini.sample.service.RoleService;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    public List<Role> getRoleList() {
        return DataSet.selectList(Role.class);
    }
}
