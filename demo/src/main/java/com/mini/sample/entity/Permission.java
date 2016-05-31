package com.mini.sample.entity;


import com.mini.framework.annotation.Entity;

@Entity
public class Permission {

    private long id;

    private String permissionName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }
}
