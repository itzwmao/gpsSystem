package com.gps;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * <p>HSBC</p>
 * <p>作者：毛兆伟</p>
 * <p>邮箱：itzwmao@163.com</p>
 * <p>创建时间： 2018年11月16日 下午7:26:30 </p>
 * <p>类说明：测试入口和API生成平台</p>
 * <p>修改记录： </p> 
 */
@Configuration
public class SwaggerConfig {

	/** 
	 * 通过 createRestApi函数来构建一个DocketBean
	 * @author 毛兆伟 
	 * @return Docket
	 * @throws 
	 */
	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())//调用apiInfo方法,创建一个ApiInfo实例,里面是展示在文档页面信息内容
				.select()
				//控制暴露出去的路径下的实例
				//如果某个接口不想暴露,可以使用以下注解
				//@ApiIgnore 这样,该接口就不会暴露在 swagger2 的页面下
				.apis(RequestHandlerSelectors.basePackage("com.gps.controller"))
				//错误路径不监控
				.paths(Predicates.not(PathSelectors.regex("/error.*")))
				.paths(PathSelectors.any())
				.build();
	}
	//构建 api文档的详细信息函数
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				//页面标题
				.title("It's API for GPS system!")
				//版本号
				.version("1.0")
				//描述
				.description("API description.")
				.build();
	}
}