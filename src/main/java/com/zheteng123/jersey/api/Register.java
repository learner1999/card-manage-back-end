package com.zheteng123.jersey.api;

import com.zheteng123.jersey.pojo.User;
import com.zheteng123.jersey.pojo.UserRegInfo;
import com.zheteng123.jersey.service.RegisterService;
import com.zheteng123.jersey.service.UserService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created on 2016/10/20.
 */

@Path("register")
public class Register {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
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

    @GET
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public boolean getUserByTelephone(@QueryParam("telephone") String telephone) {
        UserService userService = new UserService();
        return userService.getUserByTelephone(telephone) != null;
    }
}
