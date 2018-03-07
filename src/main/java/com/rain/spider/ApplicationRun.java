package com.rain.spider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@MapperScan("com.rain.spider.jd.dao") 	//扫描dao接口文件
@ComponentScan(basePackages={"com.rain.spider.jd","com.geccocrawler.gecco.spring"})
@SpringBootApplication
public class ApplicationRun {

	
	public static void main(String[] args) {
		SpringApplication.run(ApplicationRun.class, args);
	}
}
