package com.happgo.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.happgo.common.Utils.IDUtils;
import com.happgo.common.pojo.EasyUIDataGridResult;
import com.happgo.common.pojo.HappgoResult;
import com.happgo.dao.ItemDao;
import com.happgo.dao.ItemDescDao;
import com.happgo.dao.ItemParamItemDao;
import com.happgo.pojo.Item;
import com.happgo.pojo.ItemDesc;
import com.happgo.pojo.ItemParamItem;
import com.happgo.pojo.ItemQuery;
import com.happgo.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemDao itemDao;
	@Autowired
	private ItemDescDao itemDescDao;
	@Autowired
	private ItemParamItemDao itemParamItemDao;
	
	
	
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

	@Override
	public HappgoResult addItem(Item item, ItemDesc desc, String itemParam) {
		//生成商品id
				final long itemId = IDUtils.genItemId();
				//补全pojo的内容
				item.setId(itemId);
				//1-正常，2-下架，3-删除
				item.setStatus((byte) 1);
				Date date = new Date();
				item.setCreated(date);
				item.setUpdated(date);
				//插入数据库
				itemDao.insert(item);
				//插入商品描述
				desc.setItemId(itemId);
				desc.setCreated(date);
				desc.setUpdated(date);
				itemDescDao.insert(desc);
				//插入规格参数数据
				//创建一个规格参数的pojo
				ItemParamItem itemParamItem = new ItemParamItem();
				itemParamItem.setItemId(itemId);
				itemParamItem.setParamData(itemParam);
				itemParamItem.setCreated(date);
				itemParamItem.setUpdated(date);
				//插入规格参数数据
				itemParamItemDao.insert(itemParamItem);
				
				//发送商品添加消息
				/*jmsTemplate.send(activeMQTopic, new MessageCreator() {
					
					@Override
					public Message createMessage(Session session) throws JMSException {
						TextMessage textMessage = session.createTextMessage(itemId + "");
						return textMessage;
					}
				});*/
				//返回成功
				return HappgoResult.ok();
	}

	
	
}
