package com.rain.spider.jd.dao;

import org.apache.ibatis.annotations.Insert;

import com.rain.spider.jd.bean.Product;

public interface ProductMapper {
	
	
	@Insert("insert into mobile "
			+ "(sku,title,price,detailurl,img_path,shop,comments,good_comm_rate) "
			+ "values "
			+ "(#{sku},#{title},#{price.p},#{detailUrl}"
			+ ",#{imgPath},#{shop},#{comments.commentCount},#{comments.goodRate})")
	int insert(Product product);

}
