package com.happgo.service;

import com.happgo.common.pojo.EasyUIDataGridResult;
import com.happgo.common.pojo.HappgoResult;
import com.happgo.pojo.Item;
import com.happgo.pojo.ItemDesc;

public interface ItemService {

	EasyUIDataGridResult getItemList(int page,int rows);
	
	HappgoResult addItem(Item item, ItemDesc desc, String itemParam);
	
}
