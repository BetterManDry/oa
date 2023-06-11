package com.lynu.service;

import com.lynu.bean.AskForLeave;
import com.lynu.bean.Emp;

import java.util.List;

public interface EmpService {
    List<Emp> selAllService(int index,int pageSize,String likeName);

    boolean addEmpService(Emp emp);

    Emp selEmpNoSer(int deptNo);

    boolean updateEmpSer(Emp emp);

    List<Emp> checkEmpNameSer(String empName);

    boolean delEmpSer(Integer empNo);

    int getCountSer(String likeName);

    boolean delMoreSer(String ids);

    //查询全部请假记录
    List<AskForLeave> queryEmpAfl(int pageIndex,int pageSize);

    //查询请假人名字
    String queryEmpNameById(int empId);

    int getCountAfl();

    //批准请假
    int upAskForLeaveById(int state,int id);

}
