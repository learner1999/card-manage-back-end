package com.zheteng123.jersey.api;

/**
 * Created by feige_com on 2016/11/24.
 */
import com.zheteng123.jersey.pojo.Member;
import com.zheteng123.jersey.pojo.Store;
import com.zheteng123.jersey.service.MemberService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("member")
public class MemberResource {

    private MemberService memberService=new MemberService();

    @Context
    private HttpServletRequest request;

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
        HttpSession session = request.getSession();
        Store store = (Store) session.getAttribute("store");

        // 判断是否登录
        if (store == null) {
            return Response.status(Response.Status.FORBIDDEN).build();
        }

        record.setStoreId(store.getId());

        // 判断记录是否已经存在
        if (memberService.selectByStoreIdAndUserId(record.getStoreId(), record.getUserId()) != null) {
            return Response.status(Response.Status.CONFLICT).build();
        }

        if (memberService.insert(record)) {
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

    @GET
    @Path("store")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByStoreId() {
        HttpSession session = request.getSession();
        Store store = (Store) session.getAttribute("store");

        if (store == null) {
            return Response.status(Response.Status.FORBIDDEN).build();
        }

        List<Member> members = memberService.selectByStoreId(store.getId());

        if (members == null) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }

        if (members.size() == 0) {
            return Response.status(Response.Status.NO_CONTENT).build();
        }

        return Response.ok().entity(members).build();
    }


}
