package com.lynu.service;

import com.lynu.bean.AskForLeave;
import com.lynu.bean.CheckAtten;
import com.lynu.bean.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpSideService {
    //查询此员工的信息
    Emp queryEmpByNameAndPass(Emp emp);

    //查询请假总条数
    int queryAflCountByEmpId(int empId);

    //查看每一页的请假记录
    List<AskForLeave> queryAfls(int empId,int pageIndex,int pageSize);

    //请假申请
    boolean insert(AskForLeave askForLeave);

//    void addEmpId();
//
//    void setByEmpId();

    //打卡
    int upEmpCheckAtten(int i,int id);

    //检测是否打卡
    CheckAtten queryCheckAttenByEmpId(Integer empNo);

    //单挑查询
    AskForLeave queryAflById(int id);

    //修改密码
    boolean upEmpPass(int id, String newPass);

    //检测原密码
    boolean queryEmpPassById(Integer empNo, String mPass);

    //完善学生信息
    boolean upEmpPwesonal(Emp emp);
}
