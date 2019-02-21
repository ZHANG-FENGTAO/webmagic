package com.zft.demo;

import org.apache.commons.lang3.StringUtils;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Selectable;

import java.util.List;

public class MyProcessor implements PageProcessor {

	private Site site = Site.me().setRetryTimes(10).setSleepTime(1000);
	private static int count = 0;

	@Override
	public Site getSite() {
		return site;
	}


	@Override
	public void process(Page page) {
		Html html = page.getHtml();
		ResultItems resultItems = page.getResultItems();
		if (page.getUrl().regex("http://www.ccgp.gov.cn/cggg/zygg/zbgg/index.*.htm").match()){
			//
			List<String> all = page.getHtml().xpath("//*ul[@class=\"c_list_bid\"]/li/a").links().all();
			page.addTargetRequests(all);
			Selectable xpath = page.getHtml().xpath("//*[@id=\"detail\"]/div[2]/div/div[1]/div/div[2]/div[2]/p/a");
			List<String> list = page.getHtml().xpath("//a[@class=\"next\"]").links().all();
			page.addTargetRequests(list);

		}else {
			String url = page.getUrl().get();
			String title = page.getHtml().xpath("//h2[@class='tc']/text()").get();
			List<String> allContent = page.getHtml().xpath("//div[@class='vF_detail_content']/p/text()").all();
			allContent.removeIf(StringUtils::isBlank);
			Selectable xpath = page.getHtml().xpath("//div[@class='table']//a");
			System.out.println(title);
			System.out.println(allContent);
		}
	}

	public static void main(String[] args) {
		long startTime, endTime;
		System.out.println("开始爬取...");
		startTime = System.currentTimeMillis();
		Spider.create(new MyProcessor()).addUrl("http://www.ccgp.gov.cn/cggg/zygg/zbgg/index.htm").thread(5).run();
		endTime = System.currentTimeMillis();
		System.out.println("爬取结束，耗时约" + ((endTime - startTime) / 1000) + "秒，抓取了" + count + "条记录");
	}

}