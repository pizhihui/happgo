package com.happgo.dao;

import com.happgo.pojo.ItemParam;
import com.happgo.pojo.ItemParamQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ItemParamDao {
    int countByExample(ItemParamQuery example);

    int deleteByExample(ItemParamQuery example);

    int deleteByPrimaryKey(Long id);

    int insert(ItemParam record);

    int insertSelective(ItemParam record);

    List<ItemParam> selectByExampleWithBLOBs(ItemParamQuery example);

    List<ItemParam> selectByExample(ItemParamQuery example);

    ItemParam selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ItemParam record, @Param("example") ItemParamQuery example);

    int updateByExampleWithBLOBs(@Param("record") ItemParam record, @Param("example") ItemParamQuery example);

    int updateByExample(@Param("record") ItemParam record, @Param("example") ItemParamQuery example);

    int updateByPrimaryKeySelective(ItemParam record);

    int updateByPrimaryKeyWithBLOBs(ItemParam record);

    int updateByPrimaryKey(ItemParam record);
}