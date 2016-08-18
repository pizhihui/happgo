import java.io.FileNotFoundException;
import java.io.IOException;

import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;

public class FsdfsTest {

		//客户端配置文件
		public String conf_filename = 
				"D:\\develop\\eclipseProject\\workspace\\happgo\\happgo-manager-web\\src\\main\\resources\\fdfs_client.conf"; 
	    //本地文件，要上传的文件
		public String local_filename = "D:\\test.jpg";

		//上传文件
	    @Test 
	    public void testUpload() { 
	    	
	    	for(int i=0;i<5;i++){

	        try { 
	            ClientGlobal.init(conf_filename); 

	            TrackerClient tracker = new TrackerClient(); 
	            TrackerServer trackerServer = tracker.getConnection(); 
	            StorageServer storageServer = null; 

	            StorageClient storageClient = new StorageClient(trackerServer, 
	                    storageServer); 
	            NameValuePair nvp [] = new NameValuePair[]{ 
	                    new NameValuePair("item_id", "100010"), 
	                    new NameValuePair("width", "80"),
	                    new NameValuePair("height", "90")
	            }; 
	            String fileIds[] = storageClient.upload_file(local_filename, null, 
	                    nvp); 

	            System.out.println(fileIds.length); 
	            System.out.println("组名：" + fileIds[0]); 
	            System.out.println("路径: " + fileIds[1]); 

	        } catch (FileNotFoundException e) { 
	            e.printStackTrace(); 
	        } catch (IOException e) { 
	            e.printStackTrace(); 
	        } catch (Exception e) {
				e.printStackTrace();
			} 
	    	}
	    }

}
	

