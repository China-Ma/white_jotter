package com.china.white_jotter.admin.controller;

import com.china.white_jotter.admin.entity.Login;
import com.china.white_jotter.admin.service.LoginService;
import com.china.white_jotter.util.Result;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

import org.apache.shiro.subject.Subject;
import javax.servlet.http.HttpSession;


/**
 * @author majiaju
 * @date
 */
@RestController
public class AdminController {

    @Autowired
    LoginService loginService;

    /**
     * 登录
     * @param login
     * @param session
     * @return
     */
    @RequestMapping("/api/login")
    public Result login(@RequestBody Login login, HttpSession session){
        String username = login.getUsername();
        Subject subject = SecurityUtils.getSubject();
        subject.getSession().setTimeout(10000);
        UsernamePasswordToken u = new UsernamePasswordToken(username,login.getPassword());

        try{
            subject.login(u);
            return new Result(login);
        }catch (Exception e){
            e.printStackTrace();
            return new Result(400,"账号或密码错误");
        }
    }

    /**
     * 注册
     * @param login
     * @return
     */
    @RequestMapping("/api/register")
    public Result register(@RequestBody Login login){
        String username = login.getUsername();
        String password = login.getPassword();
        username = HtmlUtils.htmlEscape(username);
        login.setUsername(username);

        boolean exist = loginService.isExist(username);
        if (exist) {
            String msg = "用户名已被使用";
            return new Result(400,msg);
        }

        // 生成盐，默认长度16位
        String salt  = new SecureRandomNumberGenerator().nextBytes().toString();
        // 设置 hash 算法迭代次数
        int times = 2;
        // 得到hash后的密码
        String encodedPwd = new SimpleHash("md5",password,salt,times).toString();
        // 存储用户信息，包括salt与hash后的密码
        login.setSalt(salt);
        login.setPassword(encodedPwd);
        loginService.add(login);

        return new Result(login);
    }
}
