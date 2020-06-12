package com.gardenbaby.AgileLogistics.control;



import com.gardenbaby.AgileLogistics.dao.Service.UserService;
import com.gardenbaby.AgileLogistics.dao.dataobject.Users;
import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Properties;

@Controller
public class loginControl {

    //@test admin 管理员账号用户
    Users admin = new Users("admin", "123456");
    String kaptchaText = new String();

    @Autowired
    DefaultKaptcha kaptcha;
    @Autowired
    UserService userService;


    @RequestMapping(path = "/login")
    public String login(@RequestParam("usename")String username, @RequestParam("pwd")String pwd,@RequestParam("kaptcha")String kaptchakey, HttpSession session, Model model) {

        Users user = new Users(username,pwd);
        Users user1 = userService.selectOne(username);

        //验证码判断
        if (kaptchakey.equals(kaptchaText)) {
            //账号的判断
            if (user.getPwd().equals(user1.getPwd())) {
                session.setAttribute("user", user1);
                return "main.html";
            }
        }
        System.out.println("登录失败");

        model.addAttribute("errorText", "账号或密码错误");
        return "login.html";
    }

    @RequestMapping(path = "/register")
    public String register(Users user, Model model) {
        if (user.getPwd() != null && user.getUsername() != null) {
            userService.add(user);
            model.addAttribute("errorText", "注册成功，请登录");
            return "login.html";
        }
        model.addAttribute("errorText", "账号或者密码为空");
        return"login.html";
    }



    @Bean
    public DefaultKaptcha initKaptcha(){
        DefaultKaptcha kaptcha = new DefaultKaptcha();
        Properties properties = new Properties();
        Config config = new Config(properties);
        kaptcha.setConfig(config);
        return kaptcha;
    }
    //添加响应头信息
    @RequestMapping(path = "/captcha")
    public void getCaptcha(HttpServletResponse response, HttpSession session) throws IOException {

        //设置Http Cache 响应头
        response.setDateHeader("Expires", 0);
        // Set standard HTTP/1.1 no-cache headers.
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        // Set IE extended HTTP/1.1 no-cache headers (use addHeader).
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        // Set standard HTTP/1.0 no-cache header.
        response.setHeader("Pragma", "no-cache");

        //设置返回图片的格式
        // return a jpeg
        response.setContentType("image/png");
        // create the text for the image

        //产生随机数
        String capText = kaptcha.createText();
        kaptchaText = capText;
        // store the text in the session
        session.setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);
        // create the image with the text

        //转换成图片并且输出
        BufferedImage bi = kaptcha.createImage(capText);
        ServletOutputStream out = response.getOutputStream();
        // write the data out
        ImageIO.write(bi, "png", out);
        try {
            out.flush();
        } finally {
            out.close();
        }

    }

}
