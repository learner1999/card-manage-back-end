package com.zheteng123.jersey.api;

import com.zheteng123.jersey.pojo.CardViewInfo;
import com.zheteng123.jersey.pojo.User;
import com.zheteng123.jersey.service.CardViewInfoService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created on 2016/12/15.
 */
@Path("cardViewInfo")
public class CardViewInfoResource {

    @Context
    private HttpServletRequest request;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response selectByUserId() {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null) {
            return Response.status(Response.Status.FORBIDDEN).build();
        }

        CardViewInfoService cardViewInfoService = new CardViewInfoService();
        List<CardViewInfo> cardViewInfos = cardViewInfoService.selectByUserId(user.getId());

        return Response.ok().entity(cardViewInfos).build();
    }
}
