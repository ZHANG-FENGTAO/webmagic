package com.zft.demo.proxy.jdkproxy;

/**
 * @author zft
 * @date 2019/3/25.
 */
public class Teacher implements Study{
	@Override
	public String learnSomething(String s) {
		System.out.println("teacher learning jdk proxy");
		return s;
	}

	public static void main(String[] args) {

	}
}
