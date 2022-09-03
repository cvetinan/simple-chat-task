package com.qaiware.interview.technicaltask.config;

import com.qaiware.interview.technicaltask.constant.URLMappings;
import com.qaiware.interview.technicaltask.message.interceptor.MessageRequestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    private final MessageRequestInterceptor messageRequestInterceptor;

    @Autowired
    public WebMvcConfig(MessageRequestInterceptor messageRequestInterceptor) {
        this.messageRequestInterceptor = messageRequestInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(this.messageRequestInterceptor)
                .addPathPatterns(URLMappings.Message.BASE_PATH + "/*");
    }
}
