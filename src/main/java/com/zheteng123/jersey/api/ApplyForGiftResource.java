package com.zheteng123.jersey.api;

import com.zheteng123.jersey.pojo.ApplyForGift;
import com.zheteng123.jersey.pojo.Gift;
import com.zheteng123.jersey.pojo.Store;
import com.zheteng123.jersey.pojo.User;
import com.zheteng123.jersey.service.ApplyForGiftService;
import com.zheteng123.jersey.service.GiftService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created on 2016/12/13.
 */
@Path("applyForGift")
public class ApplyForGiftResource {

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

        ApplyForGiftService applyForGiftService = new ApplyForGiftService();
        List<ApplyForGift> applyForGiftList = applyForGiftService.selectByStoreId(store.getId());

        if (applyForGiftList.size() == 0) {
            return Response.noContent().build();
        }

        return Response.ok().entity(applyForGiftList).build();
    }

    @GET
    @Path("user")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Response selectByStoreIdAndUserId(@QueryParam("storeId") int storeId) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null) {
            return Response.status(Response.Status.FORBIDDEN).build();
        }

        ApplyForGiftService applyForGiftService = new ApplyForGiftService();
        List<ApplyForGift> applyForGiftList = applyForGiftService.selectByStoreIdAndUserId(storeId, user.getId());

        if (applyForGiftList.size() == 0) {
            return Response.noContent().build();
        }

        return Response.ok().entity(applyForGiftList).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response insert(ApplyForGift applyForGift) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null) {
            return Response.status(Response.Status.FORBIDDEN).build();
        }

        GiftService giftService = new GiftService();
        Gift gift = giftService.selectByPrimaryKey(applyForGift.getGiftId());
        if (gift.getStock() == 0) {
            return Response.status(Response.Status.NO_CONTENT).build();  // 表示已经没有库存了
        }

        applyForGift.setUserId(user.getId());
        ApplyForGiftService applyForGiftService = new ApplyForGiftService();
        boolean result = applyForGiftService.insert(applyForGift);

        if (!result) {
            return Response.serverError().build();
        }

        return Response.ok().entity(applyForGift).build();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateById(ApplyForGift applyForGift, @PathParam("id") int id) {
        HttpSession session = request.getSession();
        Store store = (Store) session.getAttribute("store");

        if (store == null) {
            return Response.status(Response.Status.FORBIDDEN).build();
        }

        ApplyForGiftService applyForGiftService = new ApplyForGiftService();
        ApplyForGift applyForGiftBefore = applyForGiftService.selectByPrimaryId(id);

        GiftService giftService = new GiftService();
        Gift gift = giftService.selectByPrimaryKey(applyForGiftBefore.getGiftId());
        if (gift.getStoreId() != store.getId()) {
            return Response.status(Response.Status.FORBIDDEN).build();
        }

        boolean result = applyForGiftService.updateByPrimaryKey(applyForGift, id);

        if (!result) {
            return Response.serverError().build();
        }

        return Response.ok().entity(applyForGift).build();
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteById(@PathParam("id") int id) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null) {
            return Response.status(Response.Status.FORBIDDEN).build();
        }

        ApplyForGiftService applyForGiftService = new ApplyForGiftService();
        ApplyForGift applyForGift = applyForGiftService.selectByPrimaryId(id);
        if (applyForGift.getUserId() != user.getId()) {
            return Response.status(Response.Status.FORBIDDEN).build();
        }

        boolean result = applyForGiftService.deleteByPrimaryKey(id);

        if (!result) {
            return Response.serverError().build();
        }

        return Response.ok().entity(applyForGift).build();
    }
}
