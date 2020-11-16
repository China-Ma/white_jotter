package com.china.white_jotter.util;

import com.china.white_jotter.admin.entity.Login;
import com.china.white_jotter.admin.service.LoginService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author majiaju
 * @date
 */
public class Realm extends AuthorizingRealm {
    @Autowired
    private LoginService loginService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo s = new SimpleAuthorizationInfo();
        return s;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String userName = authenticationToken.getPrincipal().toString();
        Login login = loginService.getByUserName(userName);
        String pwdInDB = login.getPassword();
        String salt = login.getSalt();
        SimpleAuthenticationInfo authorizationInfo = new SimpleAuthenticationInfo(userName,pwdInDB, ByteSource.Util.bytes(salt),getName());
        return authorizationInfo;
    }
}
