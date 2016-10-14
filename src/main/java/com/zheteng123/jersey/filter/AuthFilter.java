package com.zheteng123.jersey.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created on 2016/10/12.
 */
public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String url = request.getRequestURI();
        if (!"/api/login/".equals(url) && !"/api/login".equals(url) && null == request.getSession().getAttribute("user")) {
            HttpServletResponse response = ((HttpServletResponse) servletResponse);
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            response.setStatus(403);
            response.setContentType("application/json;charset=UTF-8");
            out.print("{\"error\":\"你没有权限\"}");
            return;
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
