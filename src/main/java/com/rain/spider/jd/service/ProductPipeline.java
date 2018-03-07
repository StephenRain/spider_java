package com.rain.spider.jd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.rain.spider.jd.bean.Product;
import com.rain.spider.jd.dao.ProductMapper;

@Service("productPipeline")
public class ProductPipeline implements Pipeline<Product> {

	@Autowired
	ProductMapper pm;

	@Override
	public void process(Product bean) {

		System.out.println("productpipeline======product=" + bean);

		int i = pm.insert(bean);
		System.out.println("插入数据，返回数据"+i);

	}

}
