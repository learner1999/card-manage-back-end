package com.zheteng123.jersey.api;

import com.zheteng123.jersey.pojo.LoginInfo;
import com.zheteng123.jersey.pojo.Store;
import com.zheteng123.jersey.service.StoreLoginService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 * Created on 2016/10/17.
 */
@Path("storelogin")
public class StoreLogin {

    @Context
    private HttpServletRequest request;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Store login(LoginInfo loginInfo) {
        StoreLoginService storeLoginService = new StoreLoginService();
        Store store = storeLoginService.login(loginInfo);

        // 登录成功
        if (store != null) {
            // 设置 session
            HttpSession session = request.getSession();
            session.setAttribute("store", store);

            // 去掉密码部分
            store.setOwner_password("");
        }
        return store;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Store getLoginStatus() {
        HttpSession session = request.getSession();
        return (Store) session.getAttribute("store");
    }
}
