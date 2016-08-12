package com.happgo.dao;

import java.util.List;

import com.happgo.pojo.TestTb;

public interface TestTbDao {

	public void addTestTb(TestTb testTb);
	
	public List<TestTb> getAllTest();
	
}
