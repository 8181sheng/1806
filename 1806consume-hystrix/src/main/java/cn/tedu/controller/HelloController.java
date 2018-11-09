package cn.tedu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import cn.tedu.feign.HelloFeign;

@RestController

public class HelloController {
	@Autowired //注入Feign接口
	private HelloFeign helloFeign;
	@RequestMapping("/hello/{name}")
	@HystrixCommand(fallbackMethod="helloFallback") //配置断路器
	public String hello(@PathVariable String name){
		//调用提供者
		return helloFeign.hello(name);                                          
	}
	
	//对应上面的方法，参数必须一致，当访问失败时，hystrix直接回调用此方法
	public String helloFallback(String name){
		return "tony";	//失败调用时，返回默认值
	}

}
