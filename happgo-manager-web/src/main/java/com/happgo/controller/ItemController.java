package com.happgo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.happgo.common.pojo.EasyUIDataGridResult;
import com.happgo.common.pojo.HappgoResult;
import com.happgo.pojo.Item;
import com.happgo.pojo.ItemDesc;
import com.happgo.service.ItemService;

@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@RequestMapping(value = "/item/list")
	@ResponseBody
	public EasyUIDataGridResult getItemList(int page,int rows) {
		EasyUIDataGridResult list = itemService.getItemList(page, rows);
		return list;
	}
	
	@RequestMapping(value = "/item/save")
	@ResponseBody
	public HappgoResult saveItem(Item item,String desc,String itemParam) {
		ItemDesc itemDesc = new ItemDesc();
		itemDesc.setItemDesc(desc);
		HappgoResult result = itemService.addItem(item, itemDesc, itemParam);
		return result;
	}
	
}
