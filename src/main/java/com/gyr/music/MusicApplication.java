package com.gyr.music;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 热更新，热加载
 * 1、ctrl+shift+a--》搜索registry，找到registry...，然后勾选compiler.automake.allow.when.app.running
 * 2、改完代码后，ctrl+F9
 */
@SpringBootApplication
@MapperScan("com.gyr.music.dao")
public class MusicApplication {

    public static void main(String[] args) {
        SpringApplication.run(MusicApplication.class, args);
    }

}
