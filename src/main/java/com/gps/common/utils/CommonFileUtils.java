package com.gps.common.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;

import com.mysql.jdbc.StringUtils;

/**
 * <p>HSBC</p>
 * <p>作者：毛兆伟</p>
 * <p>邮箱：itzwmao@163.com</p>
 * <p>创建时间： 2018年11月16日 下午7:28:51 </p>
 * <p>类说明：文件存储性能保证工具类</p>
 * <p>修改记录： </p> 
 */
public class CommonFileUtils {

	/**
	 * 保证存储文件的性能，单文件夹文件数量不超过1024
	 * 
	 * @return
	 * @throws IOException
	 * @throws IllegalStateException
	 */
	public static void uploadFile(MultipartFile multipartFile) throws IllegalStateException, IOException {
		String originalFilename = multipartFile.getOriginalFilename();
		if(!StringUtils.isNullOrEmpty(originalFilename)) {
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd\\hh\\mm\\ss");
			String path = "D:" + File.separator +"uploads"+File.separator+ format.format(new Date());
			File file = new File(path);
			if (!file.exists()) {
				file.mkdirs();
			}
			String filePath = path +File.separator + UUID.randomUUID().toString()
					+ originalFilename.substring(originalFilename.lastIndexOf('.'));
			multipartFile.transferTo(new File(filePath));
		}
	}
	/**
	 * 多文件上传到磁盘：一个file input选多个文件，一次提交多个file input
	 * @param multipartFiles
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	public static void uploadMultiFile(MultiValueMap<String, MultipartFile>  multipartFiles) throws IllegalStateException, IOException {
		Iterator<String> it = multipartFiles.keySet().iterator();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd\\hh\\mm\\ss");
		if(multipartFiles.size()>=2) {
			int input = 0;
			while(it.hasNext()) {
				String path = "D:" + File.separator +"uploads"+File.separator+ format.format(new Date())+File.separator+"input"+(input++);
				File file = new File(path);
				if (!file.exists()) {
					file.mkdirs();
				}
				Iterator<MultipartFile> files = multipartFiles.get(it.next()).iterator();
				while(files.hasNext()) {
					MultipartFile multipartFile = files.next();
					String originalFilename = multipartFile.getOriginalFilename();
					if(!StringUtils.isNullOrEmpty(originalFilename)) {
						String filePath = path +File.separator + UUID.randomUUID().toString()
								+ originalFilename.substring(originalFilename.lastIndexOf('.'));
						multipartFile.transferTo(new File(filePath));
					}
				}
			}
		}else {
			String path = "D:" + File.separator +"uploads"+File.separator+ format.format(new Date())+File.separator+"singleinput";
			File file = new File(path);
			if (!file.exists()) {
				file.mkdirs();
			}
			if(it.hasNext()) {
				Iterator<MultipartFile> files = multipartFiles.get(it.next()).iterator();
				while(files.hasNext()) {
					MultipartFile multipartFile = files.next();
					String originalFilename = multipartFile.getOriginalFilename();
					if(!StringUtils.isNullOrEmpty(originalFilename)) {
						String filePath = path +File.separator + UUID.randomUUID().toString()
								+ originalFilename.substring(originalFilename.lastIndexOf('.'));
						multipartFile.transferTo(new File(filePath));
					}
				}
			}
		}
	}
	
	public static String getWebProjectPath(HttpServletRequest request) {
		return request.getSession().getServletContext().getRealPath(File.separator);
	}
}
