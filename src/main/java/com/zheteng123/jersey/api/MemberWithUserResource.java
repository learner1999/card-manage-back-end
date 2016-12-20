package com.zheteng123.jersey.api;

import com.zheteng123.jersey.pojo.MemberWithUser;
import com.zheteng123.jersey.pojo.Store;
import com.zheteng123.jersey.service.MemberWithUserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created on 2016/12/20.
 */
@Path("memberWithUser")
public class MemberWithUserResource {

    @Context
    private HttpServletRequest request;

    @GET
    @Path("store")
    @Produces(MediaType.APPLICATION_JSON)
    public Response selectByStoreId() {
        HttpSession session = request.getSession();
        Store store = (Store) session.getAttribute("store");

        if (store == null) {
            return Response.status(Response.Status.FORBIDDEN).build();
        }

        MemberWithUserService memberWithUserService = new MemberWithUserService();
        List<MemberWithUser> memberWithUsers = memberWithUserService.selectByStoreId(store.getId());

        return Response.ok().entity(memberWithUsers).build();
    }
}
