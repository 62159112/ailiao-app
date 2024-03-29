package com.chongdong.ailiaoapp.service;

import com.chongdong.ailiaoapp.model.ResponseMap;
import com.chongdong.ailiaoapp.model.Trends;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author cd
* @description 针对表【tcd_trends(用户动态表)】的数据库操作Service
* @createDate 2023-09-22 10:53:04
*/
public interface TrendsService extends IService<Trends> {

    //删除单个动态
    ResponseMap deleteTrends(Long id);

    ResponseMap selectOneTrends(Long id);

    ResponseMap AllQueryTrends(Long userid);

    ResponseMap addOrEdit(Trends trends);
}
