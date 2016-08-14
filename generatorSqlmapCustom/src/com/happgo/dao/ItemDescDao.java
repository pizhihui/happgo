package com.happgo.dao;

import com.happgo.pojo.ItemDesc;
import com.happgo.pojo.ItemDescQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ItemDescDao {
    int countByExample(ItemDescQuery example);

    int deleteByExample(ItemDescQuery example);

    int deleteByPrimaryKey(Long itemId);

    int insert(ItemDesc record);

    int insertSelective(ItemDesc record);

    List<ItemDesc> selectByExampleWithBLOBs(ItemDescQuery example);

    List<ItemDesc> selectByExample(ItemDescQuery example);

    ItemDesc selectByPrimaryKey(Long itemId);

    int updateByExampleSelective(@Param("record") ItemDesc record, @Param("example") ItemDescQuery example);

    int updateByExampleWithBLOBs(@Param("record") ItemDesc record, @Param("example") ItemDescQuery example);

    int updateByExample(@Param("record") ItemDesc record, @Param("example") ItemDescQuery example);

    int updateByPrimaryKeySelective(ItemDesc record);

    int updateByPrimaryKeyWithBLOBs(ItemDesc record);

    int updateByPrimaryKey(ItemDesc record);
}