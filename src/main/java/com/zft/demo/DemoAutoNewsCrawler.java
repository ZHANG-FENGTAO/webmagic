package com.zft.demo;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.rocks.BreadthCrawler;

/**
 * @author zft
 * @date 2019/2/21.
 */
public class DemoAutoNewsCrawler extends BreadthCrawler {
	/**
	 * @param crawlPath crawlPath is the path of the directory which maintains
	 *                  information of this crawler
	 * @param autoParse if autoParse is true,BreadthCrawler will auto extract
	 *                  links which match regex rules from pag
	 */
	private static String baseUrl="http://www.ccgp.gov.cn/cggg/zygg/zbgg/";

	private DemoAutoNewsCrawler(String crawlPath, boolean autoParse) {
		super(crawlPath, autoParse);
		/*start pages*/
		this.addSeed(baseUrl);
		for(int pageIndex = 2; pageIndex <= 5; pageIndex++) {
			String seedUrl = String.format("http://www.ccgp.gov.cn/cggg/zygg/zbgg/index_%d.htm", pageIndex);
			this.addSeed(seedUrl);
		}

		/*fetch url like "https://blog.github.com/2018-07-13-graphql-for-octokit/" */
		this.addRegex("baseUrl");


		setThreads(50);
		getConf().setTopN(100);

	}

	@Override
	public void visit(Page page, CrawlDatums next) {
		String url = page.url();
		/*if page is news page*/
		if (page.matchUrl("http://www.ccgp.gov.cn/cggg/zygg/zbgg/.*")) {

			/*extract title and content of news by css selector*/
			String title = page.select("h1[class=lh-condensed]").first().text();
			String content = page.selectText("div.content.markdown-body");

			System.out.println("URL:\n" + url);
			System.out.println("title:\n" + title);
			System.out.println("content:\n" + content);

			/*If you want to add urls to crawl,add them to nextLink*/
			/*WebCollector automatically filters links that have been fetched before*/
            /*If autoParse is true and the link you add to nextLinks does not match the
              regex rules,the link will also been filtered.*/
			//next.add("http://xxxxxx.com");
		}
	}

	public static void main(String[] args) throws Exception {
		DemoAutoNewsCrawler crawler = new DemoAutoNewsCrawler("crawl", true);
		/*start crawl with depth of 4*/
		crawler.start(4);
	}

}