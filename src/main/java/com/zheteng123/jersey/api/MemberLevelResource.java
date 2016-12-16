package com.zheteng123.jersey.api;

import com.zheteng123.jersey.pojo.MemberLevel;
import com.zheteng123.jersey.pojo.Store;
import com.zheteng123.jersey.service.MemberLevelService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created on 2016/12/10.
 */

@Path("memberLevel")
public class MemberLevelResource {

    @Context
    private HttpServletRequest request;

    @GET
    @Path("store/{storeId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findMemberLevelByStoreId(@PathParam("storeId") int storeId) {

        MemberLevelService memberLevelService = new MemberLevelService();
        List<MemberLevel> memberLevels = memberLevelService.findMemberLevelByStoreId(storeId);

        return Response.ok().entity(memberLevels).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addMemberLevel(MemberLevel memberLevel) {

        HttpSession session = request.getSession();
        Store store = (Store) session.getAttribute("store");
        if (store == null) {
            return Response.status(Response.Status.FORBIDDEN).build();
        }

        MemberLevelService memberLevelService = new MemberLevelService();
        memberLevel.setStoreId(store.getId());
        boolean result = memberLevelService.addMemberLevel(memberLevel);

        if (result) {
            return Response.ok().entity(memberLevel).build();
        } else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }


    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateMemberLevel(@PathParam("id") int id, MemberLevel memberLevel) {

        HttpSession session = request.getSession();
        Store store = (Store) session.getAttribute("store");

        if (store == null) {
            return Response.status(Response.Status.FORBIDDEN).build();
        }

        MemberLevelService memberLevelService = new MemberLevelService();

        MemberLevel memberLevelFind = memberLevelService.findById(id);
        if (memberLevelFind == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else if (memberLevelFind.getStoreId() != store.getId()) {
            return Response.status(Response.Status.FORBIDDEN).build();
        }

        memberLevel.setStoreId(store.getId());
        boolean result = memberLevelService.updateMemberLevel(memberLevel);

        if (result) {
            return Response.ok().entity(memberLevel).build();
        } else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
}
