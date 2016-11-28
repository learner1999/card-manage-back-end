package com.zheteng123.jersey.api;

import com.zheteng123.jersey.pojo.Favorites;
import com.zheteng123.jersey.pojo.User;
import com.zheteng123.jersey.service.FavoritesService;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created on 2016/11/22.
 */
@Path("/favorites")
public class FavoritesResource {

    @Context
    private HttpServletRequest request;

    // 查询当前登录用户收藏的商家
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Favorites> findAllFavoritesByCurrentUser() {
        FavoritesService favoritesService = new FavoritesService();
        User user = (User) request.getSession().getAttribute("user");
        int userId = user.getId();
        return favoritesService.selectAllByUserId(userId);
    }

    // 为当前登录用户添加商家收藏
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addFavoritesForCurrentUser(Favorites favorites) {
        FavoritesService favoritesService = new FavoritesService();
        User user = (User) request.getSession().getAttribute("user");
        int userId = user.getId();

        if (favoritesService.isExist(userId, favorites)) {
            return Response.status(Response.Status.CONFLICT).build();
        }

        if (favoritesService.insertByUserId(userId, favorites) == 1) {
            return Response.ok().entity(favorites).build();
        }

        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }

    // 删除当前用户的商家收藏
    @DELETE
    @Path("store/{storeId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addFavoritesForCurrentUser(@PathParam("storeId") int storeId) {
        FavoritesService favoritesService = new FavoritesService();
        User user = (User) request.getSession().getAttribute("user");
        int userId = user.getId();
        int counter = favoritesService.deleteByUserIdAndStoreId(userId, storeId);
        if (counter == 1) {
            return Response.ok().build();
        }
        if (counter == 0) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }

}
