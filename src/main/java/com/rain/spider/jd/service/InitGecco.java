package com.rain.spider.jd.service;

import org.springframework.stereotype.Service;

import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.spring.SpringGeccoEngine;
@Service
public class InitGecco extends SpringGeccoEngine{

	@Override
	public void init() {
		
//		GeccoEngine.create()
//        .pipelineFactory(springPipelineFactory)  //在与spring整合必须使用这个，否则会无法使用自定义的pipeline
//        .classpath("com.rain.spider.jd")
//        .start("https://list.jd.com/list.html?cat=9987,653,655&page=1")
//        .interval(3000)
//        .start();
		
		GeccoEngine.create()
        .pipelineFactory(springPipelineFactory)  //在与spring整合必须使用这个，否则会无法使用自定义的pipeline
        .classpath("com.rain.spider.jd")
        .start("")
        .interval(3000)
        .start();
		
	}

}
