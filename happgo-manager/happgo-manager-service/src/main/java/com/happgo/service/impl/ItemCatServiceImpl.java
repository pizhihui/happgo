package com.happgo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.happgo.dao.ItemCatDao;
import com.happgo.pojo.ItemCat;
import com.happgo.pojo.ItemCatQuery;
import com.happgo.service.ItemCatService;

@Service
public class ItemCatServiceImpl implements ItemCatService{

	@Autowired
	private ItemCatDao itemCatDao;
	
	@Override
	public List<ItemCat> getItemCatList(long parentId) {
		ItemCatQuery example = new ItemCatQuery();
		example.createCriteria().andParentIdEqualTo(parentId);
		List<ItemCat> itemCatList = itemCatDao.selectByExample(example);
		return itemCatList;
	}
	
}
