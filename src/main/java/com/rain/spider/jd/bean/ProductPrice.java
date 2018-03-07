package com.rain.spider.jd.bean;

import com.geccocrawler.gecco.annotation.JSONPath;
import com.geccocrawler.gecco.spider.JsonBean;

import lombok.Data;

@Data
public class ProductPrice implements JsonBean {
	private static final long serialVersionUID = 1L;

	@JSONPath("$[0].op")
	private String op;

	@JSONPath("$[0].m")
	private String m;

	@JSONPath("$[0].p")
	private float p;

}
