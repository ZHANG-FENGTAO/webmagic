package com.zft.demo;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;

/**
 * @author zft
 * @date 2019/2/21.
 */
public class TutorialCrawler extends BreadthCrawler {

	public TutorialCrawler(String crawlPath, boolean autoParse) {
		super(crawlPath, autoParse);
	}

	@Override
	public void visit(Page page, CrawlDatums next) {
		if (page.matchUrl("http://blog.csdn.net/.*/article/details/.*")) {
			String title = page.select("div[class=c_list_bid]").first().text();
			String author = page.select("div[id=blog_userface]").first().text();
			System.out.println("title:" + title + "\tauthor:" + author);
		}
	}

	public static void main(String[] args) throws Exception {
		TutorialCrawler crawler = new TutorialCrawler("crawler", true);
		crawler.addSeed("http://blog.csdn.net/");
		crawler.addRegex("http://blog.csdn.net/.*/article/details/.*");

		/*可以设置每个线程visit的间隔，这里是毫秒*/
		//crawler.setVisitInterval(1000);
		/*可以设置http请求重试的间隔，这里是毫秒*/
		//crawler.setRetryInterval(1000);

		crawler.setThreads(30);
		crawler.start(2);
	}

}
