package com.happgo.dao;

import com.happgo.pojo.ItemParamItem;
import com.happgo.pojo.ItemParamItemQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ItemParamItemDao {
    int countByExample(ItemParamItemQuery example);

    int deleteByExample(ItemParamItemQuery example);

    int deleteByPrimaryKey(Long id);

    int insert(ItemParamItem record);

    int insertSelective(ItemParamItem record);

    List<ItemParamItem> selectByExampleWithBLOBs(ItemParamItemQuery example);

    List<ItemParamItem> selectByExample(ItemParamItemQuery example);

    ItemParamItem selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ItemParamItem record, @Param("example") ItemParamItemQuery example);

    int updateByExampleWithBLOBs(@Param("record") ItemParamItem record, @Param("example") ItemParamItemQuery example);

    int updateByExample(@Param("record") ItemParamItem record, @Param("example") ItemParamItemQuery example);

    int updateByPrimaryKeySelective(ItemParamItem record);

    int updateByPrimaryKeyWithBLOBs(ItemParamItem record);

    int updateByPrimaryKey(ItemParamItem record);
}