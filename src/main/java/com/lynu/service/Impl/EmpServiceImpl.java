package com.lynu.service.Impl;

import com.lynu.bean.AskForLeave;
import com.lynu.bean.Emp;
import com.lynu.mapper.AskForLeaveMapper;
import com.lynu.mapper.DeptMapper;
import com.lynu.mapper.EmpMapper;
import com.lynu.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    EmpMapper empMapper;

    @Autowired
    DeptMapper deptMapper;

    @Autowired
    AskForLeaveMapper askForLeaveMapper;

    @Override
    public List<Emp> selAllService(int index,int pageSize,String likeName) {
        return empMapper.selAll(index,pageSize,likeName);
    }

    @Override
    public boolean addEmpService(Emp emp) {
        System.out.println("Service emp = " + emp);
        int i = empMapper.addEmp(emp);
        if (i > 0){
            return true;
        }
        return false;
    }

    @Override
    public Emp selEmpNoSer(int deptNo) {
        return empMapper.selEmpNo(deptNo);
    }

    @Override
    public boolean updateEmpSer(Emp emp) {
        return empMapper.updateEmp(emp);
    }

    @Override
    public List<Emp> checkEmpNameSer(String empName) {
        return empMapper.checkEmpName(empName);
    }

    @Override
    public boolean delEmpSer(Integer empNo) {
        int i = empMapper.logiDel(empNo);
        if (i > 0){
            return true;
        }
        return false;
    }

    @Override
    public int getCountSer(String likeName) {
        return empMapper.getCount(likeName);
    }

    @Override
    public boolean delMoreSer(String ids) {
        int i = empMapper.logiDelMore(ids);
        if (i > 0){
            return true;
        }
        return false;
    }

    //查询全部请假记录
    @Override
    public List<AskForLeave> queryEmpAfl(int pageIndex,int pageSize) {
        return askForLeaveMapper.selectEmpAflByState(pageIndex,pageSize);
    }

    //查询请假人名字
    @Override
    public String queryEmpNameById(int empId) {
        return empMapper.selectEmpNameById(empId);
    }

    @Override
    public int getCountAfl() {
        return askForLeaveMapper.selectCountAfl();
    }

    //批准请假
    @Override
    public int upAskForLeaveById(int state,int id) {
        return askForLeaveMapper.updateAskForLeaveById(state,id);
    }



}
