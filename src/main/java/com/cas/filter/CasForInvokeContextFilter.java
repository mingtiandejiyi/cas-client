package com.cas.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 该过滤器用户从CAS认证服务器中获取登录用户用户名，并填充必要的Session.
 *
 * @author bjf
 * @created 2018-05-06
 */

public class CasForInvokeContextFilter implements Filter {

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpSession httpSession = ((HttpServletRequest) request).getSession();
        if (((HttpServletRequest) request).getUserPrincipal() != null) {
            //如果session中没有用户信息，则填充用户信息
            //客户端登录校验方法
            if (httpSession.getAttribute("userId") == null) {
                //客户端登录方法
                httpSession.setAttribute("userId", "1");

            }
        }
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
    }
}

