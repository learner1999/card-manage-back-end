package com.zheteng123.jersey.api;

import com.zheteng123.jersey.pojo.Preferential;
import com.zheteng123.jersey.service.PreferentialService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created on 2016/11/20.
 */

@Path("preferential")
public class PreferentialResource {

    private PreferentialService preferentialService = new PreferentialService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Preferential> findPreferentialAll() {
        return preferentialService.selectAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addPreferential(Preferential preferential) {

        if (preferentialService.insert(preferential) == 1) {
            return Response.status(Response.Status.OK).entity(preferential).build();
        }

        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updatePreferential(Preferential preferential) {

        if (preferentialService.update(preferential) == 1) {
            return Response.status(Response.Status.OK).entity(preferential).build();
        }

        return Response.status(Response.Status.NOT_FOUND).build();
    }

}
