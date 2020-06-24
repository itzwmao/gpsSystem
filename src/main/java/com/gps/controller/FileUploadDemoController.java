package com.gps.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import com.gps.common.utils.CommonFileUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 * <p>HSBC</p>
 * <p>作者：毛兆伟</p>
 * <p>邮箱：itzwmao@163.com</p>
 * <p>创建时间： 2018年11月16日 下午7:27:19 </p>
 * <p>类说明：文件上传控制器</p>
 * <p>修改记录： </p> 
 */
@RestController
@Api(value="文件上传接口",tags={"UploadFileAPI"})
public class FileUploadDemoController {

	//文件存储到服务器上会用到
	private static String webPath = "";
	
	@ApiIgnore(value="跳转到文件上传界面")
	@RequestMapping(value = "/toUploadFilePage.do", method = RequestMethod.OPTIONS)
	public String toUploadFilePage(HttpServletRequest request) {
		webPath = CommonFileUtils.getWebProjectPath(request);
		return "/front/uploadFileDemo.jsp";
	}
	
	@ApiOperation(value="单文件上传方法", notes="单文件上传方法")
	@RequestMapping(value = "/uploadFileDemo.do", method = RequestMethod.POST)
	public void uploadFileDemo(MultipartFile bigImage) throws IllegalStateException, IOException {
		CommonFileUtils.uploadFile(bigImage);
	}
	
	@ApiOperation(value="多文件上传方法", notes="多文件上传方法")
	@RequestMapping(value = "/uploadMultiFileDemo.do", method = RequestMethod.POST)
	public void uploadMultiFileDemo(MultipartRequest multipartRequest) throws IllegalStateException, IOException {
		CommonFileUtils.uploadMultiFile(multipartRequest.getMultiFileMap());
	}
}
