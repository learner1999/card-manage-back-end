package com.zheteng123.jersey.service;

import com.zheteng123.jersey.mapper.ExchangeTicketMapper;
import com.zheteng123.jersey.pojo.ExchangeTicket;
import com.zheteng123.jersey.utils.DbUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Created on 2016/12/22.
 */
public class ExchangeTicketService {

    /**
     * 根据用户id查询兑换券信息
     * @param userId 用户id
     * @return 兑换券信息
     */
    public List<ExchangeTicket> selectByUserId(int userId) {
        SqlSession sqlSession = DbUtils.getSqlSession();
        ExchangeTicketMapper mapper = sqlSession.getMapper(ExchangeTicketMapper.class);

        List<ExchangeTicket> exchangeTickets = mapper.selectByUserId(userId);

        sqlSession.close();
        return exchangeTickets;
    }
}
