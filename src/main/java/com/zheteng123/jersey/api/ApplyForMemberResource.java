package com.zheteng123.jersey.api;

import com.zheteng123.jersey.pojo.ApplyForMember;
import com.zheteng123.jersey.pojo.Store;
import com.zheteng123.jersey.pojo.User;
import com.zheteng123.jersey.service.ApplyForMemberService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created on 2016/12/5.
 */

@Path("applyForMember")
public class ApplyForMemberResource {

    @Context
    private HttpServletRequest request;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addByStoreId(ApplyForMember applyForMember) {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        applyForMember.setUserId(user.getId());
        applyForMember.setStatus(0);

        ApplyForMemberService applyForMemberService = new ApplyForMemberService();
        if (applyForMemberService.insert(applyForMember)) {
            return Response.ok().entity(applyForMember).build();
        } else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(applyForMember).build();
        }
    }

    @GET
    @Path("store/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByStoreId(@PathParam("id") int storeId) {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        ApplyForMemberService applyForMemberService = new ApplyForMemberService();

        ApplyForMember applyForMember = new ApplyForMember();
        applyForMember.setStoreId(storeId);
        applyForMember.setUserId(user.getId());
        ApplyForMember applyForMemberData = applyForMemberService.findByUserIdAndStoreId(applyForMember);

        if (applyForMemberData == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok().entity(applyForMember).build();
        }
    }

    @DELETE
    @Path("store/{id}")
    public Response deleteByStoreId(@PathParam("id") int storeId) {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null) {
            return Response.status(Response.Status.FORBIDDEN).build();
        }

        ApplyForMemberService applyForMemberService = new ApplyForMemberService();

        boolean result = applyForMemberService.deleteByUserIdAndStoreId(storeId, user.getId());
        if (!result) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }

        return Response.ok().build();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateById(ApplyForMember applyForMember, @PathParam("id") int id) {
        HttpSession session = request.getSession();
        Store store = (Store) session.getAttribute("store");

        if (store == null) {
            return Response.status(Response.Status.FORBIDDEN).build();
        }

        ApplyForMemberService applyForMemberService = new ApplyForMemberService();
        ApplyForMember applyForMemberBefore = applyForMemberService.selectByPrimaryKey(id);
        if (applyForMemberBefore.getStoreId() != store.getId()) {
            return Response.status(Response.Status.FORBIDDEN).build();
        }

        applyForMember.setStoreId(store.getId());
        boolean result = applyForMemberService.updateByPrimaryKey(applyForMember, id);

        if (!result) {
            return Response.serverError().build();
        }

        return Response.ok().entity(applyForMember).build();
    }

    @GET
    @Path("store")
    @Produces(MediaType.APPLICATION_JSON)
    public Response selectByStoreId() {
        HttpSession session = request.getSession();
        Store store = (Store) session.getAttribute("store");

        if (store == null) {
            return Response.status(Response.Status.FORBIDDEN).build();
        }

        ApplyForMemberService applyForMemberService = new ApplyForMemberService();
        List<ApplyForMember> applyForMembers = applyForMemberService.selectByStoreId(store.getId());

        return Response.ok().entity(applyForMembers).build();
    }
}
