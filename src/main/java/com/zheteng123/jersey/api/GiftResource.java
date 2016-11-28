package com.zheteng123.jersey.api;

import com.zheteng123.jersey.mapper.GiftMapper;
import com.zheteng123.jersey.pojo.Gift;
import com.zheteng123.jersey.pojo.GiftExample;
import com.zheteng123.jersey.pojo.Member;
import com.zheteng123.jersey.pojo.MemberExample;
import com.zheteng123.jersey.service.GiftService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by feige_com on 2016/11/24.
 */
@Path("gift")
public class GiftResource {
    private GiftService giftService=new GiftService();

    /**
     * 查询所有兑换商品信息
     * @param giftExample
     * @return
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Gift> findByExample(GiftExample giftExample) {
        return giftService.selectByExample(giftExample);
    }

    /**
     * 查询兑换商品信息
     * @param id
     * @return
     */
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Gift findGiftById(@PathParam("id") Integer id) {
        return giftService.selectByPrimaryKey(id);
    }

    /**
     * 新增会员信息
     * @param record
     * @return
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addGift(Gift record) {

        if (giftService.insertSelective(record) == 1) {
            return Response.status(Response.Status.OK).entity(record).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    /**
     * 修改会员信息
     * @param id
     * @param record
     * @return
     */
    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateGift(@PathParam("id") int id,Gift record) {
        if (giftService.updateByPrimaryKeySelective(id,record) == 1) {
            return Response.status(Response.Status.OK).entity(record).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    /**
     * 删除会员信息
     * @param id
     * @return
     */
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteByPrimaryKey(@PathParam("id") Integer id) {
        if (giftService.deleteByPrimaryKey(id) == 1) {
            return Response.status(Response.Status.OK).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }






}
