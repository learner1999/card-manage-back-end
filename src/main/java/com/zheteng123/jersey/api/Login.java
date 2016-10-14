package com.zheteng123.jersey.api;

import com.zheteng123.jersey.pojo.LoginInfo;
import com.zheteng123.jersey.pojo.User;
import com.zheteng123.jersey.service.LoginService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 * Created on 2016/10/12.
 */

@Path("login")
public class Login {

    @Context
    private HttpServletRequest request;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User login(LoginInfo loginInfo) {
        LoginService loginService = new LoginService();
        User user = loginService.login(loginInfo);

        // 登录成功
        if (user != null) {
            // 设置 session
            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            // 去掉密码部分
            user.setPassword("");
        }
        return user;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public User getLoginStatus() {
        HttpSession session = request.getSession();
        return (User) session.getAttribute("user");
    }
}
