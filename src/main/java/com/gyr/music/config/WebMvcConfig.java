package com.gyr.music.config;

import com.gyr.music.common.DateConverterConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Author guoyongrun
 * @Date 2020/11/4 23:55
 * @deprecated CROS解决跨域问题
 * @Version 1.0
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {


    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")//哪些目录可以使用跨域与访问：所有
                .allowedOrigins("*")//允许哪些网站对我们这些方法进行访问：所有
                .allowedMethods("*")//允许哪些方法:所有
                .allowCredentials(true)//访问是否需要验证
                .allowedHeaders("*");
    }

    /**
     * 自定义日期转换器Convert
     * @param registry
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new DateConverterConfig());
    }
}
