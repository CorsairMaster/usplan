package com.master.user.service;

import com.master.user.pojo.TUser;

import java.util.List;

public interface UserService {
    String sayHello(String hello);
    String getName(String name);
    List<TUser> getUserByUsername(String username);
    int insertUser(TUser user);
    int updateUserByUsername(TUser user);
    int deleteUserByUsername(String username);
}
