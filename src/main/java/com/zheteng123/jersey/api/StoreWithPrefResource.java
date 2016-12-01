package com.zheteng123.jersey.api;

import com.zheteng123.jersey.pojo.StoreWithPref;
import com.zheteng123.jersey.service.StoreWithPrefService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created on 2016/11/22.
 */
@Path("storeWithPref")
public class StoreWithPrefResource {

    @GET
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public List<StoreWithPref> findStoreWithPrefByCategory(@QueryParam("category") String category) {
        if (category == null) {
            return findStoreWithPrefAll();
        }
        StoreWithPrefService storeWithPrefService = new StoreWithPrefService();
        return storeWithPrefService.getStoreWithPrefByCategory(category);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<StoreWithPref> findStoreWithPrefAll() {
        StoreWithPrefService storeWithPrefService = new StoreWithPrefService();
        return storeWithPrefService.getStoreWithPrefAll();
    }
}
