package com.gyr.music.service;

/**
 * @Author: guoyongrun
 * @Date: 2020/11/5 21:57
 * @Description：管理员service接口
 * @Version: 1.0
 */
public interface AdminService {
    /**
     * 验证密码是否正确
     * @param username
     * @param password
     * @return
     */
    public boolean verifyPassword(String username,String password);
}
