package com.master.user.config;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    //    创建 应用名称
    @Bean
    public ApplicationConfig applicationConfig(){

        // 这是显示在 Zookeeper 的 应用名字
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("master-user-controller");
        return applicationConfig;
    }
//    创建zookeeper

    @Bean
    public RegistryConfig registryConfig(){
        RegistryConfig registryConfig = new RegistryConfig();
//        两种方式设置 Zookeeper
//        设置协议
        registryConfig.setProtocol("zookeeper");
//        设置地址
        registryConfig.setAddress("120.78.140.235:2181");// 配置地址
        return registryConfig;
    }
    //    协议和Dubbo
    @Bean
    public ProtocolConfig protocolConfig(){
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("dubbo");
        protocolConfig.setPort(12345);
        return protocolConfig;
    }
}
