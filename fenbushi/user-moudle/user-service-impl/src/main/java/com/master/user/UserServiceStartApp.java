package com.master.user;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@DubboComponentScan
@MapperScan("com.master.mapper")
public class UserServiceStartApp {
    public static void main(String[] args) {
        SpringApplication.run(UserServiceStartApp.class,args);
    }
}
