package com.mini.sample.action;


import com.mini.framework.DataContext;
import com.mini.framework.annotation.Action;
import com.mini.framework.annotation.Inject;
import com.mini.framework.annotation.Request;
import com.mini.framework.mvc.bean.Params;
import com.mini.framework.mvc.bean.Result;
import com.mini.framework.mvc.bean.View;
import com.mini.sample.bean.UserBean;
import com.mini.sample.entity.Role;
import com.mini.sample.service.PermissionService;
import com.mini.sample.service.RoleService;
import com.mini.sample.service.UserService;

import java.util.List;
import java.util.Map;

@Action
//@HasRoles("admin")
public class UserAction {

    @Inject
    private UserService userService;

    @Inject
    private RoleService roleService;

    @Inject
    private PermissionService permissionService;

    @Request.Get("/users")
    public View index() {
        List<UserBean> userBeanList = userService.findUserBeanList();
        DataContext.Request.put("userBeanList", userBeanList);
        return new View("user.jsp");
    }

    @Request.Post("/users")
    public View search(Params params) {
        String username = params.getString("username");
        List<UserBean> userBeanList = userService.findUserBeanListByUsername(username);
        DataContext.Request.put("userBeanList", userBeanList);
        return new View("user_list.jsp");
    }

    @Request.Get("/user")
    public View create() {
        List<Role> roleList = roleService.getRoleList();
        DataContext.Request.put("roleList", roleList);
        return new View("user_create.jsp");
    }

    @Request.Post("/user")
    public Result save(Params params) {
        Map<String, Object> fieldMap = params.getFieldMap();
        boolean result = userService.saveUser(fieldMap);
        return new Result(result);
    }

    @Request.Get("/user/{id}")
    public View edit(long id) {
        UserBean userBean = userService.findUserBean(id);
        DataContext.Request.put("userBean", userBean);

        List<Role> roleList = roleService.getRoleList();
        DataContext.Request.put("roleList", roleList);

        return new View("user_edit.jsp");
    }

    @Request.Put("/user/{id}")
    public Result update(long id, Params params) {
        Map<String, Object> fieldMap = params.getFieldMap();
        boolean result = userService.updateUser(id, fieldMap);
        return new Result(result);
    }

    @Request.Delete("/user/{id}")
    public Result delete(long id) {
        boolean result = userService.deleteUser(id);
        return new Result(result);
    }
}
