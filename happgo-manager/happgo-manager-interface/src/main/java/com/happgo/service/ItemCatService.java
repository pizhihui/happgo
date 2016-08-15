package com.happgo.service;

import java.util.List;

import com.happgo.pojo.ItemCat;


public interface ItemCatService {
	
	public List<ItemCat> getItemCatList(long parentId);
	
}
