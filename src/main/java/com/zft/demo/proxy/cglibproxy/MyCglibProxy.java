package com.zft.demo.proxy.cglibproxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author zft
 * @date 2019/3/25.
 */
public class MyCglibProxy implements MethodInterceptor {
	@Override
	public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
		System.out.println("黄牛代购");
		// 下面两个不正确的使用会造成死循环 栈溢出
///		Object res = method.invoke(o, objects);
///		Object res = methodProxy.invoke(o, objects);
		Object res = methodProxy.invokeSuper(o, objects);
		System.out.println("do other something");
		return res;
	}

	public static void main(String[] args) {
		MyCglibProxy myCglibProxy = new MyCglibProxy();

		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(CommonPerson.class);
		enhancer.setCallback(myCglibProxy);

		CommonPerson person = (CommonPerson) enhancer.create();
		String s = person.buyTicket("cglib动态代理");
		System.out.println(s);
	}

}
