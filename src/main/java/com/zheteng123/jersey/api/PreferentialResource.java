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

    /**
     * 查询所有商家优惠信息
     * @return 优惠信息list
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Preferential> findPreferentialAll() {
        return preferentialService.selectAll();
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Preferential findPreferentialById(@PathParam("id") int id) {
        return preferentialService.selectById(id);
    }

    /**
     * 新增优惠信息
     * @param preferential
     * @return
     */
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
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updatePreferential(@PathParam("id") int id, Preferential preferential) {

        if (preferentialService.update(id, preferential) == 1) {
            return Response.status(Response.Status.OK).entity(preferential).build();
        }

        return Response.status(Response.Status.NOT_FOUND).build();
    }

}
