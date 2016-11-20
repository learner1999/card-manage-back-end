package com.zheteng123.jersey.service;

import com.zheteng123.jersey.pojo.Comment;
import com.zheteng123.jersey.mapper.CommentMapper;
import com.zheteng123.jersey.utils.DbUtils;
import org.apache.ibatis.session.SqlSession;

import javax.annotation.Resource;
import java.util.List;

public class CommentService {

    @Resource
    private CommentMapper commentMapper;

    public CommentService() {
        SqlSession sqlSession = DbUtils.getSqlSession(true);
        commentMapper = sqlSession.getMapper(CommentMapper.class);
    }

    public int insert(Comment pojo){
        return commentMapper.insert(pojo);
    }

    public int insertList(List<Comment> pojos){
        return commentMapper.insertList(pojos);
    }

    public List<Comment> select(Comment pojo){
        return commentMapper.select(pojo);
    }

    public int update(Comment pojo){
        return commentMapper.update(pojo);
    }

    public List<Comment> selectByStoreId(int storeId) {
        return commentMapper.selectByStoreId(storeId);
    }

    public Comment selectById(int id) {
        Comment comment = new Comment();
        comment.setId(id);
        return commentMapper.select(comment).get(0);
    }
}
