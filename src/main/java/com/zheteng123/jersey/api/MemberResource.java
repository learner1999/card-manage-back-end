package com.zheteng123.jersey.api;

/**
 * Created by feige_com on 2016/11/24.
 */
import com.zheteng123.jersey.pojo.Member;
import com.zheteng123.jersey.service.MemberService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("member")
public class MemberResource {

    private MemberService memberService=new MemberService();

    /**
     * 查询所有会员信息
     * @param memberExample
     * @return
     */
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    public List<Member> findByExample(MemberExample memberExample) {
//        return memberService.selectByExample(memberExample);
//    }

    /**
     * 查询会员信息
     * @param id
     * @return
     */
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Member findMemberById(@PathParam("id") Integer id) {
        return memberService.selectByPrimaryKey(id);
    }


    /**
     * 新增会员信息
     * @param record
     * @return
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addMember(Member record) {

        if (memberService.insertSelective(record) == 1) {
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
    public Response updateMember(@PathParam("id") Integer id,Member record) {
        if (memberService.updateByPrimaryKeySelective(id,record) == 1) {
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
        if (memberService.deleteByPrimaryKey(id) == 1) {
            return Response.status(Response.Status.OK).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }





}
