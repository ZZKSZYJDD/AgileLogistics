package com.gardenbaby.AgileLogistics.dao;


import com.gardenbaby.AgileLogistics.dataobject.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;

@Controller
public class UserDB {


    @Autowired
    UserMapper userMapper;


    public boolean add(User user){
        userMapper.insert(user);
        return true;
    }
    public ArrayList<User> selectAll(){
        ArrayList<User> users = new ArrayList<>();
        users.addAll(userMapper.selectAll());
        return users;
    }


//    public boolean delect(User user){
//        userMapper.deletByUserNamwe(user.getUsename());
//        return true;
//    }
//
//    public boolean updatePwd(User user){
//        userMapper.updatePwd(user.getPwd());
//        return true;
//    }
//
//    public User slectOne(User user){
//        return userMapper.slectOne(user.getUsename());
//    }



}
