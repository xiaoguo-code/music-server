package com.gyr.music.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: guoyongrun
 * @Date: 2020/11/8 23:35
 * @Description：定位歌手图片地址（静态资源映射)
 * @Version: 1.0
 */
@Configuration
public class SingerPicConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        System.getProperty("user.dir")//取到music-server的目录路径
//        System.getProperty("file.separator")//分隔符”/“
        registry.addResourceHandler("/img/singerPic/**")
                .addResourceLocations(
                        "file:"+ System.getProperty("user.dir")
                        +System.getProperty("file.separator")
                        +"img"+System.getProperty("file.separator")
                        +"singerPic"+System.getProperty("file.separator")
                );

    }
}

