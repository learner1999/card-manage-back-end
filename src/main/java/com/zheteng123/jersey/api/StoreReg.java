package com.zheteng123.jersey.api;

import com.zheteng123.jersey.pojo.Store;
import com.zheteng123.jersey.service.StoreRegService;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created on 2016/10/18.
 */
@Path("storereg")
public class StoreReg {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response reg(Store store) {
        // 注册
        StoreRegService storeRegService = new StoreRegService();
        Store resultStore = storeRegService.register(store);

        if (resultStore == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        resultStore.setOwner_password("");
        return Response.status(Response.Status.OK).entity(resultStore).build();
    }
}
