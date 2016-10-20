package com.zheteng123.jersey.api;

import com.zheteng123.jersey.pojo.Store;
import com.zheteng123.jersey.service.StoreService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created on 2016/10/20.
 */

@Path("store")
public class StoreResource {

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
}
