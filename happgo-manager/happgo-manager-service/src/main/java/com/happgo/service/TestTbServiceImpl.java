package com.happgo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.happgo.dao.TestTbDao;
import com.happgo.pojo.TestTb;

@Service("TestTbService")
@Transactional
public class TestTbServiceImpl implements TestTbService{

	@Autowired
	private TestTbDao testTbDao;
	
	
	@Override
	public void addTestTb(TestTb testTb) {
		testTbDao.addTestTb(testTb);
	}

	@Override
	public List<TestTb> getAllTest() {
		return testTbDao.getAllTest();
	}

}
