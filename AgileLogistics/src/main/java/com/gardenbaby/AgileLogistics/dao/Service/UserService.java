package com.gardenbaby.AgileLogistics.dao.Service;


import com.gardenbaby.AgileLogistics.dao.Mapper.UsersMapper;
import com.gardenbaby.AgileLogistics.dao.dataobject.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {


    @Autowired
    UsersMapper usersMapper;


    public boolean add(Users user){
        usersMapper.insert(user);
        return true;
    }
    public ArrayList<Users> selectAll(){
        ArrayList<Users> users = new ArrayList<>();
        users.addAll(usersMapper.selectAll());
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
    public Users selectOne(String userName){
        return usersMapper.slectOne(userName);
    }



}
