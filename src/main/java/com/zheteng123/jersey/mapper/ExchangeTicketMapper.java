package com.zheteng123.jersey.mapper;

import com.zheteng123.jersey.pojo.ExchangeTicket;

import java.util.List;

/**
 * Created on 2016/12/22.
 */
public interface ExchangeTicketMapper {

    List<ExchangeTicket> selectByUserId(int userId);
}
