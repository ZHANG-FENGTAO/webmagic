package com.zft.demo.controller;

import com.zft.demo.bean.PrimaryUserBean;
import com.zft.demo.bean.SecondaryUserBean;
import com.zft.demo.mapper.primary.PrimaryUserBeanMapper;
import com.zft.demo.mapper.secondary.OrderBeanMapper;
import com.zft.demo.mapper.secondary.SecondaryUserBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zft
 * @date 2019/3/28.
 */
@RestController
@RequestMapping("/api/test")
public class DruidCaontroller {

	@Autowired
	PrimaryUserBeanMapper primaryUserBeanMapper;

	@Autowired
	SecondaryUserBeanMapper secondaryUserBeanMapper;

	@Autowired
	OrderBeanMapper orderBeanMapper;

	@GetMapping("/user/1")
	public PrimaryUserBean testPrimary() {
		return primaryUserBeanMapper.selectByPrimaryKey(1);
	}

	@GetMapping("/user/2")
	public SecondaryUserBean testSecondary() {
		orderBeanMapper.selectByPrimaryKey(1);
		return secondaryUserBeanMapper.selectByPrimaryKey(1);
	}


}
