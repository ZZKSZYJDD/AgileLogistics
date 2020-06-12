package com.gardenbaby.AgileLogistics.control;

import com.gardenbaby.AgileLogistics.dao.Service.RegionService;
import com.gardenbaby.AgileLogistics.dao.dataobject.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class RegionControl {

    @Autowired
    RegionService regionService;


    @RequestMapping( "/selectRegionData")
    public Map<String,Object> selectRegionData(
            @RequestParam(value = "limit", required = true) Integer limit,
             @RequestParam(value = "pageIndex", required = true) Integer pageIndex,
            @RequestParam(value = "queryName")String queryName){

        return regionService.selectByBuilding(queryName,pageIndex,limit);
    }


    @RequestMapping( "/addRegionData")
    public Map<String,Object> addRegionData(Region region){
        HashMap<String,Object> map = new HashMap<>();

        boolean flag = regionService.insert(region);
        if (flag==true){
            map.put("code",1);
            map.put("message","添加成功");
        }else {
            map.put("status","error");
            map.put("message","添加失败");
        }
        return map;
    }
//updateRegionData
    @RequestMapping( "/updateRegionData")
    public Map<String,Object> updateRegionData(Region region){

        HashMap<String,Object> map = new HashMap<>();

        boolean flag = regionService.update(region);
        if (flag==true){
            map.put("code",1);
            map.put("message","修改成功");
        }else {
            map.put("status","error");
            map.put("message","修改失败");
        }
        return map;
    }

    //deleteRegionData
    @RequestMapping( "/deleteRegionData")
    public Map<String,Object> deleteRegionData( @RequestParam(value = "id", required = true) Integer id){

        HashMap<String,Object> map = new HashMap<>();

        boolean flag = regionService.delect(id);
        if (flag==true){
            map.put("code",1);
            map.put("message","删除成功");
        }else {
            map.put("status","error");
            map.put("message","删除失败");
        }
        return map;
    }
}
