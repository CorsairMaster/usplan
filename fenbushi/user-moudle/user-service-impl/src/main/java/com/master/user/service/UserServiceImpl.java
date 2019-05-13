package com.master.user.service;


import com.alibaba.dubbo.config.annotation.Service;
import com.master.mapper.TUserMapper;
import com.master.user.pojo.TUser;
import com.master.user.pojo.TUserExample;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

// 注意 这里的是  dubbo  的 service
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private TUserMapper tUserMapper;

    @Override
    public String sayHello(String hello) {
        System.out.println(hello);
        return "你好 我是"+hello+"  dubbo service "+new Date();
    }

    @Override
    public String getName(String name) {
        return "我是 "+name +"————》"+new Date();
    }

    // 使用 逆向工程 创建 的 mapper 进行  操作
    @Override
    public List<TUser> getUserByUsername(String username) {
        // 创建 Example
        TUserExample tUserExample = new TUserExample();

        TUserExample.Criteria criteria = tUserExample.createCriteria();
        // 创建 条件  就是 说 根据 用户名进行得到 User
        criteria.andUsernameEqualTo(username);

        List<TUser> tUsers = tUserMapper.selectByExample(tUserExample);

        return tUsers;
    }

    @Override
    public int insertUser(TUser user) {
        int insert = tUserMapper.insert(user);
        return insert;
    }

    @Override
    public int updateUserByUsername(TUser user) {
        TUserExample tUserExample = new TUserExample();
        // 创建 条件
        TUserExample.Criteria criteria = tUserExample.createCriteria();
        // 根据用户的 username 进行 更新用户
        criteria.andUsernameEqualTo(user.getUsername());

        // 进行更新
        int i = tUserMapper.updateByExample(user, tUserExample);

        return i;
    }

    @Override
    public int deleteUserByUsername(String username) {
        TUserExample tUserExample = new TUserExample();
        // 创建 条件
        TUserExample.Criteria criteria = tUserExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        // 进行删除
        int i = tUserMapper.deleteByExample(tUserExample);
        return i;
    }
}
