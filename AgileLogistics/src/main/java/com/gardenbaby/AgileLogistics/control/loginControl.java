package com.gardenbaby.AgileLogistics.control;



import com.gardenbaby.AgileLogistics.dao.UserDB;
import com.gardenbaby.AgileLogistics.dataobject.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class loginControl {
    ArrayList<User> users ;
    //@test admin 管理员账号用户
    User admin = new User("admin", "123456");

    @Autowired
    UserDB userDB;

    @RequestMapping(path = "/login")
    public String login(@RequestParam("usename")String username, @RequestParam("pwd")String pwd, HttpSession session, Model model) {
        users = new ArrayList<>();
        users.addAll(userDB.selectAll());

        User user = new User(username,pwd);
        //User user1 = userDB.slectOne(user);
        //账号的判断
        if (user.getPwd().equals(user1.getPwd())) {

            session.setAttribute("admin", user);

            return "main.html";

        }
        System.out.println("登录失败");

        model.addAttribute("errorText", "账号或密码错误");
        return "login.html";
    }

    @RequestMapping(path = "/register")
    public String register(User user, Model model) {
        if (user.getPwd() != null && user.getUsename() != null) {
            userDB.add(user);
            model.addAttribute("errorText", "注册成功，请登录");
            return "login.html";
        }
        model.addAttribute("errorText", "账号或者密码为空");
        return"login.html";
    }

}
