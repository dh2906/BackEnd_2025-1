package com.example.bcsd.global.config;

import com.example.bcsd.global.filter.ExceptionHandlingFilter;
import com.example.bcsd.global.filter.LogFilter;
import com.example.bcsd.global.filter.LoginCheckFilter;
import com.example.bcsd.global.interceptor.AuthorizationInterceptor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    private final AuthorizationInterceptor authorizationInterceptor;

    public WebConfig(AuthorizationInterceptor authorizationInterceptor) {
        this.authorizationInterceptor = authorizationInterceptor;
    }

    @Bean
    public FilterRegistrationBean<ExceptionHandlingFilter> exceptionHandlingFilter() {
        FilterRegistrationBean<ExceptionHandlingFilter> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(new ExceptionHandlingFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.setOrder(1);

        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean<LoginCheckFilter> loginCheckFilter() {
        FilterRegistrationBean<LoginCheckFilter> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(new LoginCheckFilter());
        registrationBean.addUrlPatterns("/articles/*", "/boards/*", "/members/*");
        registrationBean.setOrder(2);

        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean<LogFilter> logFilter() {
        FilterRegistrationBean<LogFilter> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(new LogFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.setOrder(3);

        return registrationBean;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authorizationInterceptor)
                .addPathPatterns("/articles/**", "/members/**", "/boards/**");
    }
}
