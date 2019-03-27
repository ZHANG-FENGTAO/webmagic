package com.zft.demo.mapper.secondary;

import com.zft.demo.bean.SecondaryUserBean;

public interface SecondaryUserBeanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SecondaryUserBean record);

    int insertSelective(SecondaryUserBean record);

    SecondaryUserBean selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SecondaryUserBean record);

    int updateByPrimaryKey(SecondaryUserBean record);
}