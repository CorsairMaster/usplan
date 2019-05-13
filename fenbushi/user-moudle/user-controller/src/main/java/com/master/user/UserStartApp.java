package com.master.user;


import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//注意这个 注解 是  进行扫描 Dubbo 的 注释
@DubboComponentScan
public class UserStartApp {
    public static void main(String[] args) {
        SpringApplication.run(UserStartApp.class,args);
    }
}
