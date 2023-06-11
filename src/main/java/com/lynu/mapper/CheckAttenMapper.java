package com.lynu.mapper;

import com.lynu.bean.CheckAtten;
import org.apache.ibatis.annotations.Param;

public interface CheckAttenMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CheckAtten record);

    int insertSelective(CheckAtten record);

    CheckAtten selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CheckAtten record);

    int updateByPrimaryKey(CheckAtten record);

    //打卡
    int updateCheckAtten(@Param("i") int i,@Param("empId") int empId);

    int updateCheckAtten0(int empId);

    //检测是否打卡
    CheckAtten selectCheckAttenByEmpId(Integer empId);
}