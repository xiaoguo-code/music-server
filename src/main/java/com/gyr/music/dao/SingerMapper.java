package com.gyr.music.dao;

import com.gyr.music.entity.Singer;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: guoyongrun
 * @Date: 2020/11/5 21:44
 * @Description：歌手Dao
 * @Version: 1.0
 */
@Repository
public interface SingerMapper {
    /**
     * 新增
     * @param singer
     * @return
     */
    public int insert(Singer singer);

    /**
     * 修改
     * @param singer
     * @return
     */
    public int update(Singer singer);

    /**
     * 根据id删除
     * @param id
     * @return
     */
    public int delete(Integer id);

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
