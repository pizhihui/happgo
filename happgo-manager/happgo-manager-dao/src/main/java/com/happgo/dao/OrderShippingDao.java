package com.happgo.dao;

import com.happgo.pojo.OrderShipping;
import com.happgo.pojo.OrderShippingQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderShippingDao {
    int countByExample(OrderShippingQuery example);

    int deleteByExample(OrderShippingQuery example);

    int deleteByPrimaryKey(String orderId);

    int insert(OrderShipping record);

    int insertSelective(OrderShipping record);

    List<OrderShipping> selectByExample(OrderShippingQuery example);

    OrderShipping selectByPrimaryKey(String orderId);

    int updateByExampleSelective(@Param("record") OrderShipping record, @Param("example") OrderShippingQuery example);

    int updateByExample(@Param("record") OrderShipping record, @Param("example") OrderShippingQuery example);

    int updateByPrimaryKeySelective(OrderShipping record);

    int updateByPrimaryKey(OrderShipping record);
}