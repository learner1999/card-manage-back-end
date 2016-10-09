package com.zheteng123.jersey.api;

import com.zheteng123.jersey.pojo.User;
import com.zheteng123.jersey.service.UserService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created on 2016/10/8.
 */

@Path("hello/{name}")
public class JerseyApiDemo {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> hello(@PathParam("name") String name) {
        return new UserService().getUserByUsername(name);
    }
}
