package com.mini.sample.service;

import com.mini.sample.bean.UserBean;
import com.mini.sample.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    void login(String username, String password);

    @Deprecated
    List<User> findUserList();

    List<UserBean> findUserBeanList();

    @Deprecated
    List<User> findUserListByUsername(String username);

    List<UserBean> findUserBeanListByUsername(String username);

    @Deprecated
    User findUser(long userId);

    UserBean findUserBean(long userId);

    boolean saveUser(Map<String, Object> fieldMap);

    boolean updateUser(long userId, Map<String, Object> fieldMap);

    boolean deleteUser(long userId);
}
