package com.zheteng123.jersey.api;

import com.zheteng123.jersey.pojo.Store;
import com.zheteng123.jersey.service.StoreService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created on 2016/10/20.
 */

@Path("store")
public class StoreResource {

    @Context
    private HttpServletRequest request;

    @GET
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Store> findStoreByCategory(@QueryParam("category") String category) {

        // 如果没有带参数，则查询全部
        if (category == null) {
            return findStoreAll();
        }

        StoreService storeService = new StoreService();
        return storeService.findStoreByCategory(category);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Store> findStoreAll() {
        StoreService storeService = new StoreService();

        return storeService.findStoreAll();
    }

    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateByPrimaryKey(Store store, @PathParam("id") int id) {
        HttpSession session = request.getSession();
        Store storeSession = (Store) session.getAttribute("store");

        if (storeSession == null) {
            return Response.status(Response.Status.FORBIDDEN).build();
        }

        StoreService storeService = new StoreService();
        Store storeBefore = storeService.findByPrimaryKey(id);

        boolean result = storeService.updateByPrimaryKey(store, id);

        if (!result) {
            return Response.serverError().build();
        }

        return Response.ok().entity(store).build();
    }
}
