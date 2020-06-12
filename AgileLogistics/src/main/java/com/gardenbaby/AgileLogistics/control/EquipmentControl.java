package com.gardenbaby.AgileLogistics.control;

import com.gardenbaby.AgileLogistics.dao.Service.EquipmentService;

import com.gardenbaby.AgileLogistics.dao.Service.UserService;
import com.gardenbaby.AgileLogistics.dao.dataobject.Equipment;
import com.gardenbaby.AgileLogistics.tableobject.EquipmentReturn;
import com.gardenbaby.AgileLogistics.dao.dataobject.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;



@RestController
public class EquipmentControl {
    @Autowired
    EquipmentService equipmentService;
    @Autowired
    UserService userService;

    Users users = new Users();
    HashMap<String,Object> map = new HashMap<>();
    @RequestMapping( "/selectEquipmentData")
    public Map<String,Object> selectEquipmentData(
            @RequestParam(value = "limit", required = true) Integer limit,
            @RequestParam(value = "pageIndex", required = true) Integer pageIndex,
            @RequestParam(value = "queryName")String queryName,
            @RequestParam(value = "queryType")String queryType){

        return equipmentService.selectByNameAndType(queryName,queryType,pageIndex,limit);
    }

    //addEquipmentData
    @RequestMapping( "/addEquipmentData")
    public Map<String,Object> addEquipment(EquipmentReturn equipmentReturn){

        users = userService.selectOne(equipmentReturn.getPersonLiable());
        if (users==null){
            map.put("code",-1);
            map.put("message","责任人不存在");
            return map;
        }
        Equipment equipment = new Equipment(equipmentReturn.getId(),equipmentReturn.getName(),equipmentReturn.getType(),
                users.getId(),equipmentReturn.getRemarks(),equipmentReturn.getUpdateTime());


        boolean flag = equipmentService.insert(equipment);
        if (flag==true){
            map.put("code",1);
            map.put("message","添加成功");
        }else {
            map.put("code",-1);
            map.put("status","error");
            map.put("message","添加失败");
        }
        return map;
    }
    //updateEquipmentData
    @RequestMapping( "/updateEquipmentData")
    public Map<String,Object> updateEquipmentData(EquipmentReturn equipmentReturn){

        users = userService.selectOne(equipmentReturn.getPersonLiable());
        if (users.getId()==null){
            map.put("code",-1);
            map.put("message","责任人不存在");
            return map;
        }
        Equipment equipment = new Equipment(equipmentReturn.getId(),equipmentReturn.getName(),equipmentReturn.getType(),
                users.getId(),equipmentReturn.getRemarks(),equipmentReturn.getUpdateTime());

        boolean flag = equipmentService.update(equipment);
        if (flag==true){
            map.put("code",1);
            map.put("message","修改成功");
        }else {
            map.put("code",-1);
            map.put("status","error");
            map.put("message","修改失败");
        }
        return map;
    }

    //deleteEquipmentData
    @RequestMapping( "/deleteEquipmentData")
    public Map<String,Object> deleteEquipmentData( @RequestParam(value = "id", required = true) Integer id){

        HashMap<String,Object> map = new HashMap<>();

        boolean flag = equipmentService.delect(id);
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
