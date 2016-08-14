import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.happgo.common.pojo.EasyUIDataGridResult;
import com.happgo.service.ItemService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext-dao.xml",
		"classpath:applicationContext-service.xml","classpath:applicationContext-trans.xml"})
public class TestBean {

	@Autowired
	private ItemService itemService;
	
	
	@Test
	public void testGetBean(){
		
		EasyUIDataGridResult itemList = itemService.getItemList(1, 10);
		System.out.println(itemList);
		
	}
	
}
