package com.master.user;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 *  如果 放到 tomcat 中 运行的话  那么是需要 写 这个类的    这样才会在 tomcat 中 运行起来
 */
public class UserServiceHandlerApp extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(UserServiceStartApp.class);
    }
}
