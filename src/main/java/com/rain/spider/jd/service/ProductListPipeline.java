package com.rain.spider.jd.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.scheduler.DeriveSchedulerContext;
import com.geccocrawler.gecco.scheduler.SchedulerContext;
import com.rain.spider.jd.bean.Product;
import com.rain.spider.jd.bean.ProductList;
import com.rain.spider.jd.dao.ProductMapper;

@Service("productListPipeline")
public class ProductListPipeline implements Pipeline<ProductList> {
	
	@Autowired
	ProductMapper productMapper;

    @Override
    public void process(ProductList productList) {
    	
    	HttpRequest currRequest = productList.getRequest();
        //下一页继续抓取
        int currPage = productList.getCurrPage();
        
    	int count = 0;
    	//将 productList 中的每一个product放入数据库
    	for(Product product :productList.getDetails() ){
    		//System.out.println("该数据是  ：  "+product);
    		int i = productMapper.insert(product);
    		if(i==1){
    			System.out.println("插入成功一条数据");
    			count += i;
    		}else{
    			System.out.println("插入失败一条数据");
    		}
    		
    	}
    	System.out.println("当前第"+currPage+"页  ， 共计插入"+count+"条数据！");
    	
    	
        
        int nextPage = currPage + 1;
        int totalPage = productList.getTotalPage();
        if(nextPage <= totalPage) {
            String nextUrl = "";
            String currUrl = currRequest.getUrl();
            if(currUrl.indexOf("page=") != -1) {
                nextUrl = StringUtils.replaceOnce(currUrl, "page=" + currPage, "page=" + nextPage);
            } else {
                nextUrl = currUrl + "&" + "page=" + nextPage;
            }
            DeriveSchedulerContext.into(currRequest.subRequest(nextUrl));
        }
    }

}
