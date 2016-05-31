package com.mini.sample.bean;


import com.mini.sample.entity.Permission;
import com.mini.sample.entity.Role;
import com.mini.sample.entity.User;

import java.util.List;

public class UserBean {

    private User user;
    private List<Role> roleList;
    private List<Permission> permissionList;

    public UserBean(User user, List<Role> roleList, List<Permission> permissionList) {
        this.user = user;
        this.roleList = roleList;
        this.permissionList = permissionList;
    }

    public User getUser() {
        return user;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public List<Permission> getPermissionList() {
        return permissionList;
    }
}
