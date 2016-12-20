package com.zheteng123.jersey.api;

import com.zheteng123.jersey.pojo.PointDetail;
import com.zheteng123.jersey.pojo.Store;
import com.zheteng123.jersey.pojo.User;
import com.zheteng123.jersey.service.PointDetailService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created on 2016/12/12.
 */
@Path("pointDetail")
public class PointDetailResource {

    @Context
    private HttpServletRequest request;

    @GET
    @Path("user")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByUserId(@QueryParam("storeId") int storeId) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null) {
            return Response.status(Response.Status.FORBIDDEN).build();
        }


        if (storeId != 0) {
            return findByUserIdAndStoreId(user.getId(), storeId);
        }

        PointDetailService pointDetailService = new PointDetailService();
        List<PointDetail> pointDetails = pointDetailService.findByUserId(user.getId());

        if (pointDetails == null) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        } else if (pointDetails.size() == 0) {
            return Response.status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.ok().entity(pointDetails).build();
        }
    }

    private Response findByUserIdAndStoreId(int userId, int storeId) {
        PointDetailService pointDetailService = new PointDetailService();
        List<PointDetail> pointDetails = pointDetailService.findByUserIdAndStoreId(userId, storeId);

        return Response.ok().entity(pointDetails).build();
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

        PointDetailService pointDetailService = new PointDetailService();
        List<PointDetail> pointDetails = pointDetailService.findByStoreId(store.getId());

        if (pointDetails == null) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        } else if (pointDetails.size() == 0) {
            return Response.status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.ok().entity(pointDetails).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response add(PointDetail pointDetail) {
        HttpSession session = request.getSession();
        Store store = (Store) session.getAttribute("store");

        if (store == null) {
            return Response.status(Response.Status.FORBIDDEN).build();
        }
        pointDetail.setStoreId(store.getId());

        PointDetailService pointDetailService = new PointDetailService();
        boolean result = pointDetailService.insert(pointDetail);

        if (result) {
            return Response.ok().entity(pointDetail).build();
        } else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
}
