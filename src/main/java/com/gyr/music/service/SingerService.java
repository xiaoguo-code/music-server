package com.gyr.music.service;

import com.gyr.music.entity.Singer;

import java.util.List;

/**
 * @Author: guoyongrun
 * @Date: 2020/11/5 21:57
 * @Description：歌手service接口
 * @Version: 1.0
 */
public interface SingerService {
    /**
     * 新增
     * @param singer
     * @return
     */
    public boolean insert(Singer singer);

    /**
     * 修改
     * @param singer
     * @return
     */
    public boolean update(Singer singer);

    /**
     * 根据id删除
     * @param id
     * @return
     */
    public boolean delete(Integer id);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    public Singer selectByPrimaryKey(Integer id);

    /**
     * 查询所有歌手
     * @return
     */
    public List<Singer> allSinger();

    /**
     * 根据歌手名字查询
     * @param name
     * @return
     */
    public List<Singer> singerOfName(String name);

    /**
     * 根据性别查询
     */
    public List<Singer> singerOfSex(Integer sex);
}
