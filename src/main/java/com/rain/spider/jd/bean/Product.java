package com.rain.spider.jd.bean;
import com.geccocrawler.gecco.annotation.Ajax;
import com.geccocrawler.gecco.annotation.Attr;
import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.Href;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Image;
import com.geccocrawler.gecco.annotation.Text;
import com.geccocrawler.gecco.spider.HtmlBean;

import lombok.Data;

@Data
//@Gecco(matchUrl="https://list.jd.com/list.html?cat=9987,653,655",pipelines={"consolePipeline","productPipeline"})
public class Product implements HtmlBean {

    private static final long serialVersionUID = -377053120283382723L;

    @Attr("data-sku")
    @HtmlField(cssPath=".j-sku-item")
    private String sku;	//SKU

     
    @Text
    @HtmlField(cssPath=".p-name> a > em")
    private String title; 	//商品标题

    // [] 可以匹配该bean中任意属性 
    @Ajax(url="http://p.3.cn/prices/mgets?skuIds=J_[sku]")
    private ProductPrice price;
    
    
    
    /**
     * 京东商品的图片地址一部分是放在src属性中，另一部分是放在data-lazy-img中，延迟加载。
     */
    @Image({"src","data-lazy-img"})
    @HtmlField(cssPath=".p-img > a > img")
    private String imgPath; // 图片地址

    @Href()
    @HtmlField(cssPath=".p-img > a")
    private String detailUrl;	//详情页地址

    @Attr("data-shop_name")
    @HtmlField(cssPath="div.p-shop")
    private String shop;	//店铺名称
    
    @Ajax(url="https://club.jd.com/comment/productCommentSummaries.action?referenceIds=[sku]")
    private Comments comments;	//评论数量
    
  

}