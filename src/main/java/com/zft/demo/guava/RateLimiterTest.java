package com.zft.demo.guava;

import com.google.common.util.concurrent.RateLimiter;
import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @author zft
 * @date 2019/3/28.
 */
public class RateLimiterTest {

	// 速率限制器会在可配置的速率下分配许可证。如果必要的话，
	// 每个acquire() 会阻塞当前线程直到许可证可用后获取该许可证。
	// 一旦获取到许可证，不需要再释放许可证。
	// 采用令牌桶的流控算法

	final static RateLimiter limiter = RateLimiter.create(1.0);

	static void submit(Test list, Executor executor) {
		// 控制速率
		limiter.acquire();
		executor.execute(list);

	}

	static class Test implements Runnable {
		@Override
		public void run() {
			System.out.println(System.currentTimeMillis());
		}
	}

	public static void main(String[] args) {
		Test test = new Test();
		ThreadFactory threadFactory = new ThreadFactoryBuilder()
				.setNameFormat("ratelimit-pool-%d").build();
		Executor executor = new ThreadPoolExecutor(10, 10, 1, TimeUnit.SECONDS, new LinkedBlockingQueue<>(), threadFactory);
		while (true) {
			submit(test, executor);
		}
	}

}
