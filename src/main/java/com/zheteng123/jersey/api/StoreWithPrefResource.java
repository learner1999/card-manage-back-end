package com.zheteng123.jersey.api;

import com.zheteng123.jersey.pojo.StoreWithPref;
import com.zheteng123.jersey.service.StoreWithPrefService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created on 2016/11/22.
 */
@Path("storeWithPref")
public class StoreWithPrefResource {

/*
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<StoreWithPref> findStoreWithPrefAll() {
        StoreWithPrefService storeWithPrefService = new StoreWithPrefService();
        return storeWithPrefService.getStoreWithPrefAll();
    }*/

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public int findStoreCount() {
        StoreWithPrefService storeWithPrefService = new StoreWithPrefService();
        return storeWithPrefService.getStoreCount();
    }

    @GET
    @Path("{pageNow}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<StoreWithPref> findStoreByPageNow(@PathParam("pageNow") int pageNow) {
        StoreWithPrefService storeWithPrefService = new StoreWithPrefService();
        return storeWithPrefService.getStoreByPageNow(pageNow);
    }
}
