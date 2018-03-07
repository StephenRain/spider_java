package com.rain.spider.jd.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.rain.spider.jd.bean.AllSort;
import com.rain.spider.jd.bean.Category;

 
public class FilePipeline implements Pipeline<AllSort>{

	@Override
	public void process(AllSort bean) {
		File file = new File("D://jd-splider.txt");
		
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
			
			List<Category> mobileList = bean.getMobile();
			for (Category category : mobileList) {
				oos.writeObject("===========:");
				oos.writeObject(category);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
	}

}
