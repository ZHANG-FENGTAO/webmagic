package com.zft.demo.proxy.jdkproxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author zft
 * @date 2019/3/25.
 */
public class MyProxy<T> implements InvocationHandler {

	private final T t;

	public MyProxy(T t) {
		this.t = t;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("begin proxy start learning and do other something");
		Object invoke = method.invoke(t, args);
		System.out.println("end do...");
		return invoke;
	}

	public Object createProxy() {
		return Proxy.newProxyInstance(t.getClass().getClassLoader(), new Class[]{Study.class}, new MyProxy(t));
	}

}
