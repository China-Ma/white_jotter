package com.china.white_jotter.admin.controller;

import com.china.white_jotter.admin.entity.Login;
import com.china.white_jotter.admin.service.LoginService;
import com.china.white_jotter.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;


/**
 * @author majiaju
 * @date
 */
@RestController
public class AdminController {

    @Autowired
    LoginService loginService;

    @CrossOrigin
    @RequestMapping("/api/login")
    public Result login(@RequestBody Login login, HttpSession session){
        boolean flag = loginService.login(login);

        session.setAttribute("user",login);

        if (flag){
            return new Result(login);
        }
        return new Result(400,"");
    }
}
