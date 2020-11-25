package com.gyr.music.dao;

import org.springframework.stereotype.Repository;

/**
 * @Author: guoyongrun
 * @Date: 2020/11/5 21:44
 * @Description：管理员Dao
 * @Version: 1.0
 */
@Repository
public interface AdminMapper {
    /**
     * 验证密码是否正确
     * @param username
     * @param password
     * @return
     */
    public int verifyPassword(String username,String password);
}
