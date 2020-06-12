package com.gardenbaby.AgileLogistics.dao.Service;

import com.gardenbaby.AgileLogistics.dao.Mapper.RegionMapper;
import com.gardenbaby.AgileLogistics.dao.dataobject.Region;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
@Service
public class RegionService {

    @Autowired
    RegionMapper regionMapper;




    public boolean insert(Region region){
        regionMapper.insert(region);
        return true;
    }

    public Region selectByID(Integer id){
        return regionMapper.selectByPrimaryKey(id);
    }

    public Map<String,Object> selectByBuilding(String building,int pageIndex,int limit){
        //  创建Page对象，将page，limit参数传入，必须位于从数据库查询数据的语句之前，否则不生效

        Page page= PageHelper.startPage(pageIndex,limit);
        //  ASC是根据id 正向排序，DESC是反向排序
        PageHelper.orderBy("id ASC");
        // 从数据库查询，这里返回的的allUser就已经分页成功了
        ArrayList<Region> allUser = new ArrayList<>();
        allUser.clear();
        allUser.addAll(regionMapper.selectByBuilding(building));

        // 获取查询记录总数，必须位于从数据库查询数据的语句之后，否则不生效
        long total = page.getTotal();

        // 一下是layui的分页要求的信息
        HashMap<String, Object> map = new HashMap<>();
        map.put("code",666);
        map.put("msg","请求成功");
        map.put("data",allUser);
        map.put("total",total);
        return  map;

    }

    public boolean update(Region region){
        regionMapper.updateByPrimaryKey(region);
        return true;
    }
    public boolean delect(int id ){
        regionMapper.deleteByPrimaryKey(id);
        return true;
    }

}
