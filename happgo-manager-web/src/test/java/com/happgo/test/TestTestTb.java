package com.happgo.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.happgo.dao.TestTbDao;
import com.happgo.pojo.TestTb;
import com.happgo.service.TestTbService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class TestTestTb {

	@Autowired
	private TestTbDao tbDao;
	
	@Autowired
	private TestTbService testTbService;
	
	@Test
	public void testDao(){
		TestTb tb = new TestTb();
		tb.setId(21);
		tb.setName("一点不不好");
		tb.setBirthday(new Date());
		tbDao.addTestTb(tb);
		
	}
	
	@Test
	public void testService(){
		
		List<TestTb> allTest = testTbService.getAllTest();
		System.out.println(allTest.size());
		
		
		
	}
	
}
