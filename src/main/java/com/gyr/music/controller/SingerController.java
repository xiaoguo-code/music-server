package com.gyr.music.controller;

import com.alibaba.fastjson.JSONObject;
import com.gyr.music.entity.Singer;
import com.gyr.music.service.SingerService;
import com.gyr.music.utils.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @Author: guoyongrun
 * @Date: 2020/11/8 15:38
 * @Description：歌手控制类
 * @Version: 1.0
 */
@RestController
@RequestMapping("/singer")
public class SingerController {

    @Autowired
    SingerService singerService;

    /**
     * 添加歌手
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Object addSinger(Singer singer){
        JSONObject jsonObject = new JSONObject();
        boolean flag = singerService.insert(singer);
        if(flag){
            jsonObject.put(Consts.CODE, 1);
            jsonObject.put(Consts.MSG, "添加成功");
            return jsonObject;
        }
        jsonObject.put(Consts.CODE, 0);
        jsonObject.put(Consts.MSG, "添加失败");
        return jsonObject;

    }
    /**
     * 修改歌手
     */
    @RequestMapping(value = "/update" ,method = RequestMethod.POST)
    public Object update(HttpServletRequest request, Singer singer){
        JSONObject jsonObject = new JSONObject();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date birthDate = new Date();
        try {
            //日期格式转化为date
            birthDate = dateFormat.parse(String.valueOf(singer.getBirth()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        boolean flag = singerService.update(singer);
        if(flag){
            jsonObject.put(Consts.CODE, 1);
            jsonObject.put(Consts.MSG, "修改成功");
            return jsonObject;
        }
        jsonObject.put(Consts.CODE, 0);
        jsonObject.put(Consts.MSG, "修改失败");
        return jsonObject;

    }
    /**
     * 删除歌手
     */
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public Object delete(Integer id){
        JSONObject jsonObject = new JSONObject();
        boolean flag = singerService.delete(id);
        return flag;
    }
    /**
     * 根据主键查询整个歌手对象
     */
    @RequestMapping(value = "/selectByPrimaryKey",method = RequestMethod.GET)
    public Object selectByPrimaryKey(Integer id){
        JSONObject jsonObject = new JSONObject();
        Singer singer = singerService.selectByPrimaryKey(id);
        return singer;
    }
    /**
     * 查询所有歌手
     */
    @RequestMapping(value = "/allSinger",method = RequestMethod.GET)
    public Object allSinger(){
        JSONObject jsonObject = new JSONObject();
        List<Singer> singers = singerService.allSinger();
        return singers;
    }

    /**
     * 根据歌手名字模糊查询
     */
    @RequestMapping(value = "/singerOfName",method = RequestMethod.GET)
    public Object singerOfName(String keyword){
        JSONObject jsonObject = new JSONObject();
        List<Singer> singers = singerService.singerOfName("%"+keyword+"%");
        return singers;
    }
    /**
     * 根据歌手性别
     */
    @RequestMapping(value = "/singerOfSex",method = RequestMethod.GET)
    public Object singerOfSex(Integer sex){

        List<Singer> singers = singerService.singerOfSex(sex);
        return singers;
    }

    /**
     * 更新歌手图片
     */
    @RequestMapping(value = "/updateSingerPic",method = RequestMethod.POST)
    public Object updateSingerPic(@RequestParam("file") MultipartFile avatorFile, @RequestParam("id") int id){
        JSONObject jsonObject = new JSONObject();
        if(avatorFile.isEmpty()){
            jsonObject.put(Consts.CODE, 0);
            jsonObject.put(Consts.MSG, "文件上传失败");
            return jsonObject;
        }
        String fileName = UUID.randomUUID().toString()+avatorFile.getOriginalFilename();//UUID+文件名
        String filePath = System.getProperty("user.dir")
                +System.getProperty("file.separator")
                +"img"+System.getProperty("file.separator")
                +"singerPic";
        File file1 = new File(filePath);
        //如果文件路径不存在，新增该路径
        if(!file1.exists()){
            file1.mkdir();
        }
        //实际的文件地址
        File dest = new File(filePath+System.getProperty("file.separator")+fileName);
        //存储到数据库李的相对文件地址
        String storeAvatorPath = "/img/singerPic/"+fileName;
        try {
            avatorFile.transferTo(dest);
            Singer singer = new Singer();
            singer.setId(id);
            singer.setPic(storeAvatorPath);
            boolean flag = singerService.update(singer);
            if(flag){
                jsonObject.put(Consts.CODE, 1);
                jsonObject.put(Consts.MSG, "上传成功");
                jsonObject.put("pic", storeAvatorPath);
                return jsonObject;
            }
            jsonObject.put(Consts.CODE, 0);
            jsonObject.put(Consts.MSG, "上传失败");
            jsonObject.put("pic", storeAvatorPath);
            return jsonObject;
        } catch (IOException e) {
            jsonObject.put(Consts.CODE, 0);
            jsonObject.put(Consts.MSG, e.getMessage());
            e.printStackTrace();
        }
        return jsonObject;
    }
}























