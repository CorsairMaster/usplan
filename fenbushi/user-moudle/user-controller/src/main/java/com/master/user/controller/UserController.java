package com.master.user.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.master.user.pojo.TUser;
import com.master.user.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    /**
     * 记住 这里的  userService 是调用的 Dubbo  的
     */
    @Reference
    private UserService userService;

    @RequestMapping("/sayhello")
    public String sayHello(String username){
        // 调用的 Dubbo  的 Service的方法
        return userService.sayHello(username);

    }

    @RequestMapping("/insertuser")
    public String insertUser(TUser user){
        int i = userService.insertUser(user);
        if(i>0){
            return user.toString() + " 插入成功" +new Date();
        }
        return "插入失败";
    }

    @RequestMapping("/deleteuser")
    public String deleteUserByusername(String username){
        int i = userService.deleteUserByUsername(username);
        if(i>0){
            return username + "删除 成功 " + new Date();

        }
        return username+"删除失败"+new Date();
    }
    @RequestMapping("/updateuser")
    public String updateUserByUsername(TUser user){
        int i = userService.updateUserByUsername(user);
        if(i>0){
            return user.toString() + "更新 成功 " + new Date();

        }
        return user.toString()+"更新 失败"+new Date();
    }

    @RequestMapping("/getuser")
    public String getUserByUsername(String username){
        List<TUser> userByUsername = userService.getUserByUsername(username);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String s = objectMapper.writeValueAsString(userByUsername);
            return s + "通过 "+username + " 得到 User"+new Date();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "";

    }
}
