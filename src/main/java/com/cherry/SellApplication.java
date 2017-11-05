package com.cherry;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

//mybatis 注解方式（或者配置方式）的 mapper接口类的扫描路径配置  这样mapper接口中就不用添加@Mapper注解
//@EnableCaching 用于redis缓存
@SpringBootApplication
@MapperScan(basePackages = "com.cherry.dataobject.mapper")
@EnableCaching
public class SellApplication {

	public static void main(String[] args) {
		SpringApplication.run(SellApplication.class, args);
	}
}
