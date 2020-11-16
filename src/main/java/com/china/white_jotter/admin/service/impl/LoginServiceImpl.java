package com.china.white_jotter.admin.service.impl;

import com.china.white_jotter.admin.entity.Login;
import com.china.white_jotter.admin.entity.LoginExample;
import com.china.white_jotter.admin.mapper.LoginMapper;
import com.china.white_jotter.admin.service.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author majiaju
 * @date
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Resource
    LoginMapper loginMapper;

    @Override
    public boolean login(Login login) {
        LoginExample example = new LoginExample();
        LoginExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(login.getUsername());
        criteria.andPasswordEqualTo(login.getPassword());
        List list = loginMapper.selectByExample(example);
        if (list.size() > 0) {
            return true;
        }
        return false;

    }

    @Override
    public boolean isExist(String username) {
        LoginExample example = new LoginExample();
        LoginExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        List list = loginMapper.selectByExample(example);
        if (list.size() == 0) {
            return false;
        }
        return true;
    }

    @Override
    public void add(Login login) {
        loginMapper.insert(login);
    }

    @Override
    public Login getByUserName(String userName) {
        LoginExample example = new LoginExample();
        LoginExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(userName);
        List<Login> list = loginMapper.selectByExample(example);
        return list.get(0);
    }
}
