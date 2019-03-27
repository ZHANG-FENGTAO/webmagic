package com.zft.demo.mapper.primary;

import com.zft.demo.bean.PrimaryUserBean;

public interface PrimaryUserBeanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PrimaryUserBean record);

    int insertSelective(PrimaryUserBean record);

    PrimaryUserBean selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PrimaryUserBean record);

    int updateByPrimaryKey(PrimaryUserBean record);
}