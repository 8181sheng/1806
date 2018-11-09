package com.tedu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//启动类标识是springboot
@SpringBootApplication
public class RunApp {
	//入口函数
	public static void main(String[] args) {
		//启动整个程序，暗含tomcat
		SpringApplication.run(RunApp.class, args);
		
	}
}
