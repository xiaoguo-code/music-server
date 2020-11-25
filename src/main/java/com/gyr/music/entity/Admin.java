package com.gyr.music.entity;

/**
 * @Author: guoyongrun
 * @Date: 2020/11/5 0:17
 * @Description：管理员实体类
 * @Version: 1.0
 */
public class Admin {
    /*主键*/
    private Integer id;
    /*账号*/
    private String name;
    /*密码*/
    private String password;


    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
