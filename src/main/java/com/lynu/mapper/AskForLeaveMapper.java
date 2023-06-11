package com.lynu.mapper;

import com.lynu.bean.AskForLeave;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AskForLeaveMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AskForLeave record);

    int insertSelective(AskForLeave record);

    AskForLeave selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AskForLeave record);

    int updateByPrimaryKey(AskForLeave record);

    //查询请假总条数
    int selectCount(int empId);

    //查看每一页的请假记录
    List<AskForLeave> selectAfls(@Param("empId") int empId,@Param("pageIndex") int pageIndex,@Param("pageSize") int pageSize);

    //查询全部请假（未审批）
    List<AskForLeave> selectEmpAflByState(@Param("pageIndex")int pageIndex,@Param("pageSize")int pageSize);

    //查询所有请假条数
    int selectCountAfl();

    //批准请假
    int updateAskForLeaveById(@Param("state")int state,@Param("id")int id);

}