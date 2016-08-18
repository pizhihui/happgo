package com.happgo.common.fsdfs;

import org.apache.commons.io.FilenameUtils;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.core.io.ClassPathResource;

/**
 * 分布式文件系统:存储图片文件
 *
 */
public class FastDFSUtil {
	public static String uploadPicture(byte[] files,String fullname,Long size) throws Exception{
		//初始化配置文件
		ClassPathResource resource = new ClassPathResource("fdfs_client.conf");
		ClientGlobal.init(resource.getClassLoader().getResource("fdfs_client.conf").getPath());
		//创建TrackerClient对象,得到TrackerServer对象
		TrackerClient trackerClient = new TrackerClient();
		TrackerServer trackerServer = trackerClient.getConnection();
		StorageServer storageServer = null;
		//创建StorageClient1对象
		StorageClient1 storageClient = new StorageClient1(trackerServer, storageServer );
		String extName = FilenameUtils.getExtension(fullname);
		//存储客户端上传数据
		NameValuePair[] meta_list = new NameValuePair[3];
		//meta信息里存储:文件名,文件扩展名,二进制数据
		meta_list[0] = new NameValuePair("fullname", fullname);
		meta_list[1] = new NameValuePair("extname", extName);
		meta_list[2] = new NameValuePair("bytes", String.valueOf(size));
		//存储客户端上传图片,返回的是相对路径
		String path = storageClient.upload_file1(files, extName, meta_list );
		return path;
	}
	
	
	
}
