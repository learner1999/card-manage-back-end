package com.zheteng123.jersey.api;

import com.zheteng123.jersey.pojo.CashierInfo;
import com.zheteng123.jersey.pojo.Store;
import com.zheteng123.jersey.service.CashierInfoService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created on 2016/12/10.
 */
@Path("cashierInfo")
public class CashierInfoResource {

    @Context
    private HttpServletRequest request;

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getInfoByIdAndStoreId(@PathParam("id") String id) {

        HttpSession session = request.getSession();
        Store store = (Store) session.getAttribute("store");

        CashierInfoService cashierInfoService = new CashierInfoService();
        CashierInfo cashierInfo = cashierInfoService.getByIdAndStoreId(id, store.getId());

        if (cashierInfo == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok().entity(cashierInfo).build();
        }
    }
}
