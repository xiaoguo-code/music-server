package com.gyr.music.service.impl;

import com.gyr.music.dao.AdminMapper;
import com.gyr.music.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: guoyongrun
 * @Date: 2020/11/5 21:58
 * @Description：AdminService接口实现类
 * @Version: 1.0
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;
    /**
     * 验证密码是否正确
     *
     * @param username
     * @param password
     * @return
     */
    @Override
    public boolean verifyPassword(String username, String password) {
        int i = adminMapper.verifyPassword(username, password);
        return i > 0;
    }
}
