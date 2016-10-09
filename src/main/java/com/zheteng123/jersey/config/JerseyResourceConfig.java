package com.zheteng123.jersey.config;

import org.glassfish.jersey.logging.LoggingFeature;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * Created on 2016/10/8.
 */
public class JerseyResourceConfig extends ResourceConfig {

    public JerseyResourceConfig() {

        // 这里注册的是接口实现类
        packages("com.zheteng123.jersey.api");

//        register(JacksonJsonProvider.class);

        // 注册请求日志
        register(LoggingFeature.class);
    }
}
