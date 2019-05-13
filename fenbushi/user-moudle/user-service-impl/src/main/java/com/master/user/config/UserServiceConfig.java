package com.master.user.config;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserServiceConfig {
    //    配置  程序别名
    @Bean
    public ApplicationConfig applicationConfig() {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("masterjen-user-service");
        return applicationConfig;
    }

    //    注册中心
    @Bean
    public RegistryConfig registryConfig() {
        RegistryConfig registryConfig = new RegistryConfig();
//            假设注册中心是zookeeper 地址是192.168.1.10:2181
//              方式1:zookeeper://192.168.1.10:2181
//            方式二:协议: zookeeper  地址:192.168.1.10:2181  也就是说  两种第二种方式把协议拆开了
        registryConfig.setProtocol("zookeeper");// 配置协议的类型
        registryConfig.setAddress("120.78.140.235:2181");// 配置地址
        return registryConfig;
    }

    //    协议和端口
    @Bean
    public ProtocolConfig protocolConfig() {
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("dubbo");// 配置Dubbo
        protocolConfig.setPort(12345);// 配置提供者的服务地址
        return protocolConfig;
    }
}
