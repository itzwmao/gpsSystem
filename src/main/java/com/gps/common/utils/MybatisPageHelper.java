package com.gps.common.utils;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.pagehelper.PageHelper;

/**
 * <p>HSBC</p>
 * <p>作者：毛兆伟</p>
 * <p>邮箱：itzwmao@163.com</p>
 * <p>创建时间： 2018年11月16日 下午7:28:06 </p>
 * <p>类说明：Mybatis 后台分页配置</p>
 * <p>修改记录： </p> 
 */
@Configuration
public class MybatisPageHelper {

	@Bean
	public PageHelper pageHelper() {
		
		PageHelper pageHelper = new PageHelper();
		Properties properties = new Properties();
		properties.setProperty("offsetAsPageNum", "true");
		properties.setProperty("rowBoundsWithCount", "true");
		properties.setProperty("reasonable", "true");
		pageHelper.setProperties(properties);;
		return pageHelper;
	}
}
