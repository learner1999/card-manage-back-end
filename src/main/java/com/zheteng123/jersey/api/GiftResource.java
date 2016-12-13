package com.zheteng123.jersey.api;

import com.zheteng123.jersey.pojo.Gift;
import com.zheteng123.jersey.pojo.Store;
import com.zheteng123.jersey.service.GiftService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by feige_com on 2016/11/24.
 */
@Path("gift")
public class GiftResource {
    private GiftService giftService=new GiftService();

    @Context
    private HttpServletRequest request;

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Gift findGiftById(@PathParam("id") Integer id) {
        return giftService.selectByPrimaryKey(id);
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addGift(Gift record) {
        HttpSession session = request.getSession();
        Store store = (Store) session.getAttribute("store");

        if (store == null) {
            return Response.status(Response.Status.FORBIDDEN).build();
        }

        record.setStoreId(store.getId());
        if (giftService.insert(record) == 1) {
            return Response.status(Response.Status.OK).entity(record).build();
        }
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }


    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateGift(@PathParam("id") int id,Gift record) {
        HttpSession session = request.getSession();
        Store store = (Store) session.getAttribute("store");

        if (store == null) {
            return Response.status(Response.Status.FORBIDDEN).build();
        }

        Gift gift = giftService.selectByPrimaryKey(id);
        if (gift == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        if (gift.getStoreId() != store.getId()) {
            return Response.status(Response.Status.FORBIDDEN).build();
        }

        record.setId(id);
        if (giftService.updateByPrimaryKeySelective(id,record) == 1) {
            return Response.status(Response.Status.OK).entity(record).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }


    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteByPrimaryKey(@PathParam("id") Integer id) {
        HttpSession session = request.getSession();
        Store store = (Store) session.getAttribute("store");

        if (store == null) {
            return Response.status(Response.Status.FORBIDDEN).build();
        }

        Gift gift = giftService.selectByPrimaryKey(id);
        if (gift == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        if (gift.getStoreId() != store.getId()) {
            return Response.status(Response.Status.FORBIDDEN).build();
        }

        if (giftService.deleteByPrimaryKey(id) == 1) {
            return Response.status(Response.Status.OK).build();
        }
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }


    @GET
    @Path("store")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByStoreId() {
        HttpSession session = request.getSession();
        Store store = (Store) session.getAttribute("store");

        if (store == null) {
            return Response.status(Response.Status.FORBIDDEN).build();
        }

        List<Gift> gifts = giftService.selectByStoreId(store.getId());

        if (gifts == null) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }

        if (gifts.size() == 0) {
            return Response.status(Response.Status.NO_CONTENT).build();
        }

        return Response.ok().entity(gifts).build();
    }

}
