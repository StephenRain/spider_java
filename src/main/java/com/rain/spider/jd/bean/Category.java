package com.rain.spider.jd.bean;

import java.util.List;

import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Text;
import com.geccocrawler.gecco.spider.HrefBean;
import com.geccocrawler.gecco.spider.HtmlBean;
/**
 * 表示子分类信息内容
 * @author Administrator
 *
 */
public class Category implements HtmlBean {
	
	private static final long serialVersionUID = 1L;

		//对应页面的是 摄影摄像、手机 通讯、运营商、手机配件这一大类
	 	@Text
	    @HtmlField(cssPath="dt a")
	    private String parentName;

	 	//对应页面的上述分类的的细分
	    @HtmlField(cssPath="dd a")
	    private List<HrefBean> categorys;

	    public String getParentName() {
	        return parentName;
	    }

	    public void setParentName(String parentName) {
	        this.parentName = parentName;
	    }

	    public List<HrefBean> getCategorys() {
	        return categorys;
	    }

	    public void setCategorys(List<HrefBean> categorys) {
	        this.categorys = categorys;
	    }
	
}
