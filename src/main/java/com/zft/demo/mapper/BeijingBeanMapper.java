package com.zft.demo.mapper;

import com.zft.demo.bean.BeijingBean;

public interface BeijingBeanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BeijingBean record);

    int insertSelective(BeijingBean record);

    BeijingBean selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BeijingBean record);

    int updateByPrimaryKeyWithBLOBs(BeijingBean record);

    int updateByPrimaryKey(BeijingBean record);
}