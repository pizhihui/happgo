package com.happgo.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.happgo.common.fsdfs.FastDFSClient;
import com.happgo.common.pojo.PictureResult;

@Controller
public class PictureController {

	private static final String FASTDFSCLIENT_PATH = "classpath:fdfs_client.conf";
	
	@Value("${IMAGE_SERVER_URL}")
	private String IMAGE_SERVER_URL;
	
	
	
	@RequestMapping("/pic/upload")
	@ResponseBody
	public PictureResult uploadFile(MultipartFile uploadFile){
		try {
			FastDFSClient client = new FastDFSClient(FASTDFSCLIENT_PATH);
			
			
			String oldName = uploadFile.getOriginalFilename();
			String extName = oldName.substring(oldName.indexOf(".")+1);
			String url = client.uploadFile(uploadFile.getBytes(), extName);
			url = IMAGE_SERVER_URL + url;
			PictureResult pictureResult = new PictureResult();
			pictureResult.setUrl(url);
			pictureResult.setError(0);
			return pictureResult;
		} catch (Exception e) {
			e.printStackTrace();
			PictureResult pictureResult = new PictureResult();
			pictureResult.setError(1);
			pictureResult.setMessage("上传图片出错");
			return pictureResult;
		}
		
		
	}
	
}
