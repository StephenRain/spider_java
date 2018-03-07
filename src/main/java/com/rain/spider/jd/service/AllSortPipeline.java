package com.rain.spider.jd.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.geccocrawler.gecco.pipeline.Pipeline;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.scheduler.DeriveSchedulerContext;
import com.geccocrawler.gecco.spider.HrefBean;
import com.rain.spider.jd.bean.AllSort;
import com.rain.spider.jd.bean.Category;

@Service("allSortPipeline")
public class AllSortPipeline implements Pipeline<AllSort> {

    @Override
    public void process(AllSort allSort) {
    	
    	System.out.println("allsortpipeline========");
        List<Category> categorys = allSort.getMobile();
        for(Category category : categorys) {
            List<HrefBean> hrefs = category.getCategorys();
            for(HrefBean href : hrefs) {
                String url = href.getUrl()+"&delivery=1&page=1&JL=4_10_0&go=0";
                HttpRequest currRequest = allSort.getRequest();
                DeriveSchedulerContext.into(currRequest.subRequest(url));
            }
        }
    }

}