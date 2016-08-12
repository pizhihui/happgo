package com.happgo.test;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.happgo.dao.TestTbDao;
import com.happgo.pojo.TestTb;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:*.xml"})
public class TestTestTb {

	@Autowired
	private TestTbDao tbDao;
	
	
	@Test
	public void testDao(){
		TestTb tb = new TestTb();
		tb.setId(10);
		tb.setName("张三");
		tb.setBirthday(new Date());
		tbDao.addTestTb(tb);
	}
	
	
}
