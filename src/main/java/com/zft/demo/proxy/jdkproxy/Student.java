package com.zft.demo.proxy.jdkproxy;

/**
 * @author zft
 * @date 2019/3/25.
 */
public class Student implements Study {
	@Override
	public String learnSomething(String s) {
		System.out.println("student learning jdk proxy");
		return s;
	}

	public static void main(String[] args) {
		Student student = new Student();
		MyProxy proxy = new MyProxy(student);
		Study study = (Study) proxy.createProxy();
		String s = study.learnSomething("aaaa");
		System.out.println(s);

		Teacher teacher = new Teacher();
		MyProxy proxy2 = new MyProxy(teacher);
		Study study2 = (Study) proxy2.createProxy();
		String s2 = study2.learnSomething("bbb");
		System.out.println(s2);
	}
}
