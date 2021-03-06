package com.zft.demo.controller;

import com.zft.demo.MyProcessor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import us.codecraft.webmagic.Spider;

/**
 * Created zft on 2019/2/22.
 */
@RestController
@RequestMapping("/api/test")
public class TestController {

	@GetMapping
	public String test() {

		long startTime, endTime;
		System.out.println("开始爬取...");
		startTime = System.currentTimeMillis();
		for (int i = 25; i < 500; i++) {
			Spider.create(new MyProcessor()).addUrl("http://www.ccgp-beijing.gov.cn/xxgg/sjzfcggg/sjzbjggg/index_" + i + ".html").thread(2).run();
		}
		endTime = System.currentTimeMillis();
		System.out.println("爬取结束，耗时约" + ((endTime - startTime) / 1000) + "秒，抓取了");
		return "test";
	}

}
