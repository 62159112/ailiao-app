package com.chongdong.ailiaoapp.service;

import com.chongdong.ailiaoapp.model.GiftReceive;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chongdong.ailiaoapp.model.ResponseMap;

import java.util.Date;

/**
* @author cd
* @description 针对表【tcd_gift_receive(礼物接收表)】的数据库操作Service
* @createDate 2023-09-22 11:01:52
*/
public interface GiftReceiveService extends IService<GiftReceive> {


    ResponseMap add(GiftReceive giftReceive);

    ResponseMap myGift(Long receiver);

    ResponseMap giftRanking(String date);
}
