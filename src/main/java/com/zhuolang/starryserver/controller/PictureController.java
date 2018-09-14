package com.zhuolang.starryserver.controller;

import com.zhuolang.starryserver.utils.FileUploadUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 图片上传controller
 * <p>Title: PictureController</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.cn</p> 
 * @version 1.0
 */
@Controller
public class PictureController {
	
	@Value("${IMAGE_SERVER_URL}")
	private String IMAGE_SERVER_URL;

	@RequestMapping("/pic/upload")
	@ResponseBody
	public Map picUpload(MultipartFile uploadFile) {
		HttpServletRequest request;
		System.out.println("进入上传文件了。。。。。。");
		//单个文件上传，返回文件上传后的名字
		try {
			//接收上传的文件
			//取扩展名
			//String resultStr = FileUploadUtil.uploadFile(uploadFile, request);
			String resultStr = "1d326e0e-f63b-4174-a8d6-c6b5441123ec.png";
			System.out.println(IMAGE_SERVER_URL+resultStr);
			//响应上传图片的url
			Map result = new HashMap<>();
			result.put("error", 0);
			result.put("url", IMAGE_SERVER_URL+resultStr);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			Map result = new HashMap<>();
			result.put("error", 1);
			result.put("message", "图片上传失败");
			return result;
		}
		
	}
}
