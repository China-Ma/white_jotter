package com.china.white_jotter.admin.service;

import com.china.white_jotter.admin.entity.Login;

/**
 * @author majiaju
 * @date
 */
public interface LoginService {
    boolean login(Login login);

    boolean isExist(String username);

    void add(Login login);

    Login getByUserName(String userName);
}
