package com.zheteng123.jersey.api;

import com.zheteng123.jersey.pojo.Comment;
import com.zheteng123.jersey.service.CommentService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created on 2016/11/20.
 */
@Path("comment")
public class CommentResource {

    private CommentService commentService = new CommentService();

    // 根据商家id查询所有评论
    @GET
    @Path("storeId/{storeId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Comment> findCommentByStoreId(@PathParam("storeId") int storeId) {

        return commentService.selectByStoreId(storeId);
    }

    // 新增评论
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Comment addComment(Comment comment) {

        if (commentService.insert(comment) == 1) {
            return comment;
        }

        return null;
    }

    // 修改评论表数据
    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Comment updateComment(Comment comment, @PathParam("id") int id) {

        if (commentService.update(id, comment) == 1) {
            return commentService.selectById(id);
        }

        return null;
    }
}
