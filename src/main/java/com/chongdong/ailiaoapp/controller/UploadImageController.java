package com.chongdong.ailiaoapp.controller;

import com.chongdong.ailiaoapp.factory.EntityFactory;
import com.chongdong.ailiaoapp.model.AlbumPicture;
import com.chongdong.ailiaoapp.model.ResponseMap;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class UploadImageController {
    @PostMapping("/uploadImage")
    public Map<String,Object> upload(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        //设置当前日期
        //String uploaddate= new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        //设置文件上传保存文件路径：保存在项目运行目录下的uploadFile文件夹+当前日期
        String savepath = "./images/";
        //创建文件夹,当文件夹不存在时，创建文件夹
        File folder = new File(savepath);
        if(!folder.isDirectory()){
            folder.mkdir();
        }
        String realPath = folder.getCanonicalPath();
        //建立一个listmap的返回参数
        Map<String,Object> map=new HashMap<>();
        //建立一个循环分别接收多文件
        //重命名上传的文件,为避免重复,我们使用UUID对文件分别进行命名
        String oldname=multipartFile.getOriginalFilename();//getOriginalFilename()获取文件名带后缀
        //UUID去掉中间的"-",并将原文件后缀名加入新文件
        String newname= UUID.randomUUID().toString().replace("-","")
                +oldname.substring(oldname.lastIndexOf("."));
        //建立每一个文件上传的返回参数
        //文件保存操作
        try {
            multipartFile.transferTo(new File(realPath+"/"+newname));
            //建立新文件路径,在前端可以直接访问如http://localhost:8080/uploadFile/2021-07-16/新文件名(带后缀)
            String filepath="/images/"+newname;
            //写入返回参数
            map.put("filepath",filepath);
            map.put("result", true);
        }catch (IOException ex){
            //操作失败报错并写入返回参数
            ex.printStackTrace();
            map.put("filepath","");
            map.put("result",false);
        }
        //将执行结果返回
        return map;
    }
}
