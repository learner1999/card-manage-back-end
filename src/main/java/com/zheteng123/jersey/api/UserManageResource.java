package com.zheteng123.jersey.api;

import com.zheteng123.jersey.pojo.User;
import com.zheteng123.jersey.service.UserService;

import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.Date;

/**
 * Created by feige_com on 2016/12/16.
 */
@Path("user")
public class UserManageResource {

 @PUT
 @Produces(MediaType.APPLICATION_JSON)
    public Response updateUserDetail(User user) {
     if (user.getTelephone() == null) {
         return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
     } else {
             UserService userService = new UserService();
             User user1 = userService.updateUser(user);
             if (user1 == null) {
                 return Response.status(Response.Status.NOT_FOUND).build();
             }
             return Response.ok().entity(user1).build();
     }
 }
    /*

    if (telephone == null) {
         return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
     } else {
         user.setTelephone(telephone);
         if (username != null) {
             user.setUsername(username);
         }

         if (birthday != null) {
             user.setBirthday(birthday);
         }
         if (avatar != null) {
             user.setAvatar(avatar);
         }
         if (user != null) {
             UserService userService = new UserService();
             User user1 = userService.updateUser(user);
             if (user1 == null) {
                 return Response.status(Response.Status.NOT_FOUND).build();
             }
             return Response.ok().entity(user1).build();
         }
         return Response.status(Response.Status.NOT_FOUND).build();
     }
     */

}
