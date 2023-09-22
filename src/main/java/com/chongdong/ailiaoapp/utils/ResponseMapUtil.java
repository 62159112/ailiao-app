package com.chongdong.ailiaoapp.utils;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chongdong.ailiaoapp.factory.MapFactory;
import com.chongdong.ailiaoapp.model.ResponseMap;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Service
public class ResponseMapUtil<T>{
    ResponseMap responseMap = MapFactory.createResponseMap();
    /**
     * 获取单个实体类返回数据
     * */
    public ResponseMap getEntity(T entity) {
        if (entity!=null){
            responseMap.setFlag(true);
            responseMap.setData(entity);
            responseMap.setMessage("查询单个成功");
        }else {
            responseMap.setFlag(false);
            responseMap.setData(null);
            responseMap.setMessage("查询单个失败");
        }
        return responseMap;
    }
    /**
     * 获取实体类分页列表返回数据
     * */
    public ResponseMap getPageList(Page<T> pageList, Map<String, Object> modelMap) {
        if (pageList.getRecords().size()!=0){
            responseMap.setFlag(true);
            responseMap.setData(modelMap);
            responseMap.setMessage("查询列表成功");
        }else {
            responseMap.setFlag(false);
            responseMap.setData(null);
            responseMap.setMessage("查询列表失败");
        }
        return responseMap;
    }
    /**
     * 更新实体类返回结果
     * */
    public ResponseMap updateEntity(boolean result) {
        if (result){
            responseMap.setFlag(true);
            responseMap.setData(null);
            responseMap.setMessage("修改成功");
        }else {
            responseMap.setFlag(false);
            responseMap.setData(null);
            responseMap.setMessage("修改失败");
        }
        return responseMap;
    }
    /**
     * 删除实体类返回结果
     * */
    public ResponseMap deleteEntity(boolean result) {
        if (result){
            responseMap.setFlag(true);
            responseMap.setData(null);
            responseMap.setMessage("删除成功");
        }else {
            responseMap.setFlag(false);
            responseMap.setData(null);
            responseMap.setMessage("删除失败");
        }
        return responseMap;
    }
    /**
     * 添加实体类返回结果
     * */
    public ResponseMap addEntity(boolean result) {
        if (result){
            responseMap.setFlag(true);
            responseMap.setData(null);
            responseMap.setMessage("新增成功");
        }else {
            responseMap.setFlag(false);
            responseMap.setData(null);
            responseMap.setMessage("新增失败");
        }
        return responseMap;
    }
    /**
     * 获取实体类列表返回结果
     * */
    public ResponseMap getList(List<T> entityList) {
        if (entityList.size()!=0){
            responseMap.setFlag(true);
            responseMap.setData(entityList);
            responseMap.setMessage("查询列表成功");
        }else {
            responseMap.setFlag(false);
            responseMap.setData(null);
            responseMap.setMessage("查询列表失败");
        }
        return responseMap;
    }
    /**
     * 列表统计返回结果
     * */
    public ResponseMap countList(BigDecimal countAmount){
        if (countAmount!=null){
            responseMap.setFlag(true);
            responseMap.setData(countAmount);
            responseMap.setMessage("统计列表成功");
        }else {
            responseMap.setFlag(false);
            responseMap.setData(null);
            responseMap.setMessage("统计列表失败");
        }
        return responseMap;
    }
    /**
     * 数据校验返回结果
     * */
    public ResponseMap getBindingResult(BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            bindingResult.getAllErrors().forEach(e ->{
                responseMap.setFlag(false);
                responseMap.setData("校验失败");
                responseMap.setMessage(e.getDefaultMessage());
            });
        }else {
            responseMap.setFlag(true);
            responseMap.setData(null);
            responseMap.setMessage("校验成功");
        }
        return responseMap;
    }
    /**
     * 删除列表返回结果
     * */
    public ResponseMap deleteList(Boolean removeListResult){
        if (removeListResult){
            responseMap.setFlag(true);
            responseMap.setData(null);
            responseMap.setMessage("删除列表成功");
        }else {
            responseMap.setFlag(false);
            responseMap.setData(null);
            responseMap.setMessage("删除列表失败");
        }
        return responseMap;
    }
    /**
     * 相册图片数量返回结果
     * */
    public ResponseMap countNumber(Integer count){
        if (count!=null){
            responseMap.setFlag(true);
            responseMap.setData(count);
            responseMap.setMessage("统计成功");
        }else {
            responseMap.setFlag(false);
            responseMap.setData(0);
            responseMap.setMessage("统计失败");
        }
        return responseMap;
    }
    /**
     * 获取统计结果
     * */
    public ResponseMap returnMap(Map map){
        if (map.size()!=0){
            responseMap.setFlag(true);
            responseMap.setData(map);
            responseMap.setMessage("统计成功");
        }else {
            responseMap.setFlag(false);
            responseMap.setData(null);
            responseMap.setMessage("统计失败");
        }
        return responseMap;
    }

    /**
     * 修改或添加返回结果
     * */
    public ResponseMap updateOrAddEntity(int result) {
        if (result>0){
            responseMap.setFlag(true);
            responseMap.setData(null);
            responseMap.setMessage("操作成功");
        }else {
            responseMap.setFlag(false);
            responseMap.setData(null);
            responseMap.setMessage("操作失败");
        }
        return responseMap;
    }


}
