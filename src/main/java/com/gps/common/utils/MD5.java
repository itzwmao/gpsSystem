package com.gps.common.utils;

import java.security.MessageDigest;

/**
 * <p>HSBC</p>
 * <p>作者：毛兆伟</p>
 * <p>邮箱：itzwmao@163.com</p>
 * <p>创建时间： 2018年11月16日 下午7:27:49 </p>
 * <p>类说明：MD5加密数据</p>
 * <p>修改记录： </p> 
 */
public class MD5 {

	private static final String[] digital = {"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"};
	private static String initMD5(String pwd) throws Exception {
		//将明文经过MD5加密后变成16的字节数组---->32位的字符串（16进制）
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		byte[] bytes = md5.digest(pwd.getBytes("UTF-8"));
		//用来保存最终的密文
		String digest = "";
		for (byte b : bytes) {
			int tmp = b;
			if(tmp<0) {
				tmp += 256;
			}
			//经过判断后tmp一定是正整数
			int index = tmp/16;
			int index1 = tmp%16;
			digest += digital[index]+digital[index1];
		}
		return digest;
	}

	public static String finalMd5(String pwd) throws Exception {
		return initMD5(initMD5(initMD5(initMD5(pwd)+"北特科技"+"admin")+"北特科技"+"admin")+"北特科技"+"admin");
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println(finalMd5("123456"));
	}
}
