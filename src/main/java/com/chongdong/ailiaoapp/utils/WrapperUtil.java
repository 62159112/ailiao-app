package com.chongdong.ailiaoapp.utils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;

@Service
public class WrapperUtil<T> {
    public QueryWrapper<T> wrapperTimeDesc(){
        QueryWrapper<T> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("create_time");
        return wrapper;
    }
    public QueryWrapper<T> wrapperTimeDescTrends(){
        QueryWrapper<T> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("createtime");
        return wrapper;
    }
    /**
     * 搜索通用
     * */
    public QueryWrapper<T> wrapperNormal(String search, String startTime, String endTime) {
        QueryWrapper<T> wrapper = new QueryWrapper<>();
        String start = null;
        String end = null;
        if (startTime!=null  && !startTime.equals("") && endTime!=null && !endTime.equals("")){
            start = startTime.contains("/") ? startTime.replaceAll("/", "-") : startTime;
            end = endTime.contains("/") ? endTime.replaceAll("/", "-") : endTime;
        }
        wrapper.apply(start!=null,"UNIX_TIMESTAMP(update_time) >= UNIX_TIMESTAMP('" + start + "')");
        wrapper.apply(end!=null,"UNIX_TIMESTAMP(update_time) <= UNIX_TIMESTAMP('" + end + "')");
        if (search != null && !search.equals("")) {
            wrapper.and(QueryWrapper->QueryWrapper.like( "name", search)
                    .or().like("type", search)
                    .or().like( "total", search)
                    .or().like("director", search));
        }

        wrapper.orderByDesc("update_time");
        return wrapper;
    }
    public QueryWrapper<T> wrapperUserId(Long userId){
        QueryWrapper<T> wrapper = this.wrapperTimeDesc();
        wrapper.eq("user_id",userId);
        wrapper.eq("status",0);
        return wrapper;
    }

    public QueryWrapper<T> wrapperUserIdByReport(Long userId,Integer type){
        QueryWrapper<T> wrapper = this.wrapperTimeDesc();
        wrapper.eq("reporter_id",userId);
        wrapper.eq("type",type);
        return wrapper;
    }

    public QueryWrapper<T> wrapperTrendsId(Long userId,Integer status){
        QueryWrapper<T> wrapper = this.wrapperTimeDescTrends();
        wrapper.eq("userid",userId);
        wrapper.eq("status",status);
        return wrapper;
    }

    public QueryWrapper<T> wrapperUserIdOne(Long userId){
        QueryWrapper<T> wrapper = this.wrapperTimeDescTrends();
        wrapper.eq("userid",userId);
        wrapper.eq("status",0);
        return wrapper;
    }
    public QueryWrapper<T> wrapperAlbumId(Long albumId){
        QueryWrapper<T> wrapper = this.wrapperTimeDesc();
        wrapper.eq("album_id",albumId);
        return wrapper;
    }

    public QueryWrapper<T> wrapperOpennessAlbum(){
        QueryWrapper<T> wrapper = new QueryWrapper<>();
        wrapper.eq("openness",1).between("status",0,1);
        return wrapper;
    }
    public QueryWrapper<T> wrapperReport(String search, String startTime, String endTime) {
        QueryWrapper<T> wrapper = new QueryWrapper<>();
        String start = null;
        String end = null;
        if (startTime!=null  && !startTime.equals("") && endTime!=null && !endTime.equals("")){
            start = startTime.contains("/") ? startTime.replaceAll("/", "-") : startTime;
            end = endTime.contains("/") ? endTime.replaceAll("/", "-") : endTime;
        }
        wrapper.apply(start!=null,"UNIX_TIMESTAMP(create_time) >= UNIX_TIMESTAMP('" + start + "')");
        wrapper.apply(end!=null,"UNIX_TIMESTAMP(create_time) <= UNIX_TIMESTAMP('" + end + "')");
        if (search != null && !search.equals("")) {
            wrapper.and(QueryWrapper->QueryWrapper.like( "informer_id", search)
                    .or().like("reporter_id", search)
                    .or().like( "type", search)
                    .or().like("description", search))
                    .or().like("status", search);
        }
        wrapper.orderByDesc("create_time");
        return wrapper;
    }

    public QueryWrapper<T> countReport(Long reporterId) {
        QueryWrapper<T> wrapper = new QueryWrapper<>();
        wrapper.eq("reporter_id",reporterId)
                .eq("status",1);
        return wrapper;
    }

    public QueryWrapper<T> listRelationship(Long ownerId){
        QueryWrapper<T> wrapper = new QueryWrapper<>();
        wrapper.eq("owner_id",ownerId);
        return wrapper;
    }

    public QueryWrapper<T> groupById(){
        QueryWrapper<T> wrapper = new QueryWrapper<>();
        wrapper.select("user_id").eq("status",0).groupBy("user_id");
        return wrapper;
    }
    public QueryWrapper<T> groupByReporterId(){
        QueryWrapper<T> wrapper = new QueryWrapper<>();
        wrapper.select("reporter_id").eq("status",0).groupBy("reporter_id");
        return wrapper;
    }
    public QueryWrapper<T> wrapperReporterId(Long reporterId){
        QueryWrapper<T> wrapper = this.wrapperTimeDesc();
        wrapper.eq("reporter_id",reporterId).eq("status",0);
        return wrapper;
    }
    public QueryWrapper<T> wrapperSixthPicture(Long albumId){
        QueryWrapper<T> wrapper = this.wrapperTimeDesc();
        wrapper.eq("album_id",albumId);
        return wrapper;
    }

    public QueryWrapper<T> wrapperUserInfo(Long userId){
        QueryWrapper<T> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id",userId);
        return wrapper;
    }
    public QueryWrapper<T> wrapperViolationUserInfo(Long userId){
        QueryWrapper<T> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id",userId).eq("status",2);
        return wrapper;
    }
    public QueryWrapper<T> wrapperAllRelationship(Long ownerId){
        QueryWrapper<T> wrapper = new QueryWrapper<>();
        wrapper.eq("owner_id",ownerId).or().eq("friend_id",ownerId);
        return wrapper;
    }
    public QueryWrapper<T> wrapperUserOpennessAlbum(Long userId){
        QueryWrapper<T> wrapper = this.wrapperTimeDesc();
        wrapper.eq("user_id",userId);
        wrapper.eq("openness",1);
        return wrapper;
    }
    public QueryWrapper<T> wrapperUserPrivateAlbum(Long userId){
        QueryWrapper<T> wrapper = this.wrapperTimeDesc();
        wrapper.eq("user_id",userId);
        wrapper.eq("openness",0);
        return wrapper;
    }
}
