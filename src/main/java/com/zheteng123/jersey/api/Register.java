package com.zheteng123.jersey.api;

import com.zheteng123.jersey.pojo.User;
import com.zheteng123.jersey.pojo.UserRegInfo;
import com.zheteng123.jersey.service.RegisterService;
import com.zheteng123.jersey.service.UserService;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created on 2016/10/20.
 */

@Path("register")
public class Register {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public User register(UserRegInfo userRegInfo) {
        RegisterService regService = new RegisterService();
        UserService userService = new UserService();
        boolean result =  regService.register(userRegInfo);
        if (result) {
            return userService.getUserByTelephone(userRegInfo.getTelephone());
        } else {
            return null;
        }
    }
}
