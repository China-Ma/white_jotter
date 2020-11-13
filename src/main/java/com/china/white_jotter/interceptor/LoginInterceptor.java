package com.china.white_jotter.interceptor;

import com.china.white_jotter.admin.entity.Login;
import org.springframework.web.servlet.HandlerInterceptor;
import org.apache.commons.lang.StringUtils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author majiaju
 * @date
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        String contextPath = session.getServletContext().getContextPath();

        String[] requiredAuthPages = new String[]{
                "index",
        };

        String uri = request.getRequestURI();

        uri = StringUtils.remove(uri,contextPath+"/");

        String page = uri;

        if (begingWith(page,requiredAuthPages)){
            Login login = (Login)session.getAttribute("user");
            if (login == null) {
                response.sendRedirect("login");
                return false;
            }
        }

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
