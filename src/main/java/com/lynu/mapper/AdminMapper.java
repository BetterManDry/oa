package com.lynu.mapper;

import com.lynu.bean.Admin;

public interface AdminMapper {
    int deleteByPrimaryKey(Integer adminId);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer adminId);

    boolean updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

    Admin loginAdmin(Admin admin);
}