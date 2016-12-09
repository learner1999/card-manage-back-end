package com.zheteng123.jersey.api;

import com.zheteng123.jersey.pojo.StoreSort;
import com.zheteng123.jersey.pojo.StoreWithPref;
import com.zheteng123.jersey.service.StoreWithPrefService;


import javax.ws.rs.*;
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

    @GET
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public List<StoreWithPref> findStoreWithPrefSelective(@QueryParam("category") String category,
                                                          @QueryParam("name") String name) {
        if (category != null) {
            return findStoreWithPrefByCategory(category);
        }

        if (name != null) {
            return findStoreWithPrefByName(name);
        }
        return findStoreWithPrefAll();
    }


    private List<StoreWithPref> findStoreWithPrefByCategory(String category) {
        if (category == null) {
            return findStoreWithPrefAll();
        }
        StoreWithPrefService storeWithPrefService = new StoreWithPrefService();
        return storeWithPrefService.getStoreWithPrefByCategory(category);
    }

    private List<StoreWithPref> findStoreWithPrefByName(String name) {
        if (name == null) {
            return findStoreWithPrefAll();
        }
        StoreWithPrefService storeWithPrefService = new StoreWithPrefService();
        return storeWithPrefService.getStoreWithPrefByName(name);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<StoreWithPref> findStoreWithPrefAll() {
        StoreWithPrefService storeWithPrefService = new StoreWithPrefService();
        return storeWithPrefService.getStoreWithPrefAll();
    }

    @GET
    @Path("pagecount")
    @Produces(MediaType.TEXT_PLAIN)
    public int findStoreSortCount(@QueryParam("category") String category) {
        StoreWithPrefService storeWithPrefService = new StoreWithPrefService();
        return storeWithPrefService.getStoreSortCount(category);
    }


    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<StoreWithPref> findStoreSortByPageNow(@QueryParam("pagenow") int pagenow,
                                                      @QueryParam("category") String category) {
        StoreSort storeSort=new StoreSort();
        storeSort.setPagenow(pagenow);
        storeSort.setCategory(category);
        StoreWithPrefService storeWithPrefService = new StoreWithPrefService();
        return storeWithPrefService.getStoreByPageNow(storeSort);
    }
}
