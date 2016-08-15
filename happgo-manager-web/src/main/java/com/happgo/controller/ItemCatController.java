package com.happgo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.happgo.common.pojo.EasyUITreeNode;
import com.happgo.pojo.ItemCat;
import com.happgo.service.ItemCatService;

@Controller
public class ItemCatController {

	@Autowired
	private ItemCatService itemCatService;
	
	@RequestMapping(value = "/itemcat/list")
	@ResponseBody
	public List<EasyUITreeNode> getItemList(@RequestParam(value="id",defaultValue="0")long parentId) {
		List<ItemCat> itemCatList = itemCatService.getItemCatList(parentId);
		ArrayList<EasyUITreeNode> treeNodes = new ArrayList<EasyUITreeNode>();
		for (ItemCat itemCat : itemCatList) {
			EasyUITreeNode treeNode = new EasyUITreeNode();
			treeNode.setId(itemCat.getId().intValue());
			treeNode.setText(itemCat.getName());
			treeNode.setState(itemCat.getIsParent()?"closed":"open");
			treeNodes.add(treeNode);
		}
		return treeNodes;
	}
	
}
