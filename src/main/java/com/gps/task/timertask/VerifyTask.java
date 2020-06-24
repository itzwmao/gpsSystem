package com.gps.task.timertask;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * <p>HSBC</p>
 * <p>作者：毛兆伟</p>
 * <p>邮箱：itzwmao@163.com</p>
 * <p>创建时间： 2018年11月16日 下午7:30:06 </p>
 * <p>类说明：定时任务</p>
 * <p>修改记录： </p> 
 */
@Component
public class VerifyTask {
	
	//@Scheduled(fixedDelay=1000)
	@Scheduled(cron="0/2 18 10 * * *")
	public void printDate() {
		Date date = new Date();//alt + shift + l
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(sdf.format(date));
		
	}
	
}
