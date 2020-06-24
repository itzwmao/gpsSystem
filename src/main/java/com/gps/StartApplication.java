package com.gps;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * <p>HSBC</p>
 * <p>作者：毛兆伟</p>
 * <p>邮箱：itzwmao@163.com</p>
 * <p>创建时间： 2018年11月19日 下午8:16:09 </p>
 * <p>类说明：应用启动入口</p>
 * <p>修改记录： </p> 
 */
@SpringBootApplication(scanBasePackages= {"com.gps.controller","com.gps.service.impl","com.gps.task.timertask"})
//开启spring boot的默认配置
@EnableAutoConfiguration
//开启定时器任务
@EnableScheduling
//Mybatis 事务管理功能开放
@EnableTransactionManagement
//配置 dao 层扫描
@MapperScan(basePackages = {"com.gps.mapper"})
@ServletComponentScan(value= {"com.gps.filters"})
//注解开启 swagger2 功能
@EnableSwagger2
public class StartApplication {

	public static void main(String[] args) {
		//内置了TomCat，因此不需要发布到外部 tomcat 容器中
		//spring boot 简化了 ssm 框架的搭建，类似于书写SSM的所有配置文件
		SpringApplication.run(StartApplication.class, args);
	}
	
}
