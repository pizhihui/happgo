package com.happgo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.happgo.common.pojo.EasyUIDataGridResult;
import com.happgo.dao.ItemDao;
import com.happgo.pojo.Item;
import com.happgo.pojo.ItemQuery;
import com.happgo.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemDao itemDao;
	
	@Override
	public EasyUIDataGridResult getItemList(int page, int rows) {
		//分页处理
		PageHelper.startPage(page, rows);
		//执行查询
		ItemQuery itemQuery = new ItemQuery();
		itemQuery.setOrderByClause("id desc");
		List<Item> list = itemDao.selectByExample(itemQuery);
		//取分页信息
		PageInfo<Item> pageInfo = new PageInfo<>(list);
		//创建EasyUIDataGridResult
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setTotal(pageInfo.getTotal());
		result.setRows(list);
		return result;
	}

	
	
}
