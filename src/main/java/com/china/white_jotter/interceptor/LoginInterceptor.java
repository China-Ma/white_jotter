package com.china.white_jotter.interceptor;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author majiaju
 * @date
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 放行options 请求，否则无法让前端带上自定义的 header 信息，导致 sessionId 改变，shiro验证失败
        if (HttpMethod.OPTIONS.toString().equals(request.getMethod())){
            response.setStatus(HttpStatus.NO_CONTENT.value());
            return true;
        }
        Subject subject = SecurityUtils.getSubject();
        // 使用shiro验证
        if (!subject.isAuthenticated() && !subject.isRemembered()){
            return  false;
        }
        System.out.println(subject.isRemembered());
        System.out.println(subject.isAuthenticated());
        return true;
    }

    private boolean begingWith(String page, String[] requiredAuthPages){
        boolean result = false;

        for (String requiredAuthPage : requiredAuthPages){
            if (StringUtils.startsWith(page,requiredAuthPage)){
                result = true;
                break;
            }
        }

        return result;
    }
}
