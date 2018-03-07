package com.rain.spider.jd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SpiderController {
	
	@RequestMapping("/index")
	public String index(){
		return "index";
	}

}
