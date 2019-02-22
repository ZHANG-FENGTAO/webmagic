package com.zft.demo;

import com.alibaba.fastjson.JSON;
import com.zft.demo.bean.BeijingBean;
import com.zft.demo.mapper.BeijingBeanMapper;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Selectable;

import javax.servlet.ServletContext;
import java.util.List;

public class MyProcessor implements PageProcessor {
	private Site site = Site.me().setRetryTimes(10).setSleepTime(1000);
	private static int count = 0;
	@Override
	public Site getSite() {
		return site;
	}

	private static ApplicationContext applicationContext;

	public static void setApplicationContext(ApplicationContext context) {
		applicationContext = context;
	}

	@Override
	public void process(Page page) {
		BeijingBeanMapper beijingBeanMapper = applicationContext.getBean(BeijingBeanMapper.class);
		BeijingBean beijingBean = new BeijingBean();
		if (page.getUrl().regex("http://www.ccgp-beijing.gov.cn/xxgg/sjzfcggg/sjzbjggg/index.*.html").match()){
			List<String> all = page.getHtml().xpath("//*ul[@class=\"xinxi_ul\"]/li/a").links().all();
			page.addTargetRequests(all);
			// TODO 如何获取script 加载的分页
			Selectable xpath = page.getHtml().xpath("//div[@class=\"pagigation\"]");
//			page.addTargetRequests(list);
		}else {
			String url = page.getUrl().get();
//			String title = page.getHtml().xpath("//h2[@class='tc']/text()").get();
			String title = page.getHtml().xpath("/html/body/div[2]/div[2]/span/text()").get();
			String datetime = page.getHtml().xpath("span[@class=\"datetime\"]/text()").get();
//			List<String> allContent = page.getHtml().xpath("//div[@class='vF_detail_content']/p/text()").all();
			List<String> allContent = page.getHtml().xpath("/html/body/div[2]/div[3]/p/text()").all();
			allContent.removeIf(StringUtils::isBlank);
			String content = JSON.toJSONString(allContent);
			beijingBean.setTitle(title);
			beijingBean.setUrl(url);
			beijingBean.setContent(content);
			beijingBean.setDatetime(datetime);
			beijingBeanMapper.insert(beijingBean);
		}
	}

}