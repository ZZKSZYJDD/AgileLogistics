package com.gardenbaby.AgileLogistics.dao.Service;

import com.gardenbaby.AgileLogistics.dao.Mapper.EquipmentMapper;
import com.gardenbaby.AgileLogistics.dao.dataobject.Equipment;

import com.gardenbaby.AgileLogistics.tableobject.EquipmentReturn;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class EquipmentService {
    @Autowired
    EquipmentMapper equipmentMapper;


    public boolean insert(Equipment equipment){


        equipmentMapper.insert(equipment);
        return true;
    }

    public Equipment selectByID(Integer id){
        return equipmentMapper.selectByPrimaryKey(id);
    }

    public Map<String,Object> selectByNameAndType(String name,String type,int pageIndex,int limit){
        //  创建Page对象，将page，limit参数传入，必须位于从数据库查询数据的语句之前，否则不生效

        Page page= PageHelper.startPage(pageIndex,limit);
        //  ASC是根据id 正向排序，DESC是反向排序
        PageHelper.orderBy("id ASC");
        // 从数据库查询，这里返回的的allUser就已经分页成功了
        ArrayList<EquipmentReturn> allUser = new ArrayList<>();
        allUser.clear();
        allUser.addAll(equipmentMapper.selectByNameAndType(name,type));

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

    public boolean update(Equipment equipment){
        equipmentMapper.updateByPrimaryKey(equipment);
        return true;
    }
    public boolean delect(int id ){
        equipmentMapper.deleteByPrimaryKey(id);
        return true;
    }
}
