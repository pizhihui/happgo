package com.happgo.service;

import com.happgo.common.pojo.EasyUIDataGridResult;

public interface ItemService {

	EasyUIDataGridResult getItemList(int page,int rows);
	
}
