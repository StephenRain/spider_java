package com.rain.spider.jd.bean;

import com.geccocrawler.gecco.annotation.JSONPath;
import com.geccocrawler.gecco.spider.JsonBean;
import lombok.Data;

@Data
public class Comments implements JsonBean {

	private static final long serialVersionUID = 1L;

	// 总评论数
	@JSONPath(value = "$.CommentsCount[0].CommentCount")
	private int commentCount;

	// 显示的评论数
	@JSONPath(value = "$.CommentsCount[0].ShowCount")
	private int showCount;

	// 这个不太清楚
	@JSONPath(value = "$.CommentsCount[0].DefaultGoodCount")
	private int defaultGoodCount;

	// 好评
	@JSONPath(value = "$.CommentsCount[0].GoodCount")
	private int goodCount;

	// 追加数量
	@JSONPath(value = "$.CommentsCount[0].AfterCount")
	private int afterCount;

	// 好评率
	@JSONPath(value = "$.CommentsCount[0].GoodRate")
	private float goodRate;

	// 好评率
	@JSONPath(value = "$.CommentsCount[0].PoorCount")
	private int PoorCount;

	// 好评率
	@JSONPath(value = "$.CommentsCount[0].GeneralCount")
	private float generalCount;

	// 差评率
	@JSONPath(value = "$.CommentsCount[0].PoorRate")
	private float poorRate;

	// 评分
	@JSONPath("$.CommentsCount[0].AverageScore")
	private int averageScore;

}
