package com.lynu.service.Impl;

import com.lynu.bean.AskForLeave;
import com.lynu.bean.CheckAtten;
import com.lynu.bean.Emp;
import com.lynu.mapper.AskForLeaveMapper;
import com.lynu.mapper.CheckAttenMapper;
import com.lynu.mapper.EmpMapper;
import com.lynu.service.EmpSideService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class EmpSideServiceImpl implements EmpSideService {

    @Autowired
    EmpMapper empMapper;

    @Autowired
    AskForLeaveMapper askForLeaveMapper;

    @Autowired
    CheckAttenMapper checkAttenMapper;

    //查询员工信息
    @Override
    public Emp queryEmpByNameAndPass(Emp emp) {
        return empMapper.selectEmpByNameAndPass(emp);
    }

    //查询请假总条数
    @Override
    public int queryAflCountByEmpId(int empId) {
        return askForLeaveMapper.selectCount(empId);
    }

    //查看每一页的请假记录
    @Override
    public List<AskForLeave> queryAfls(int empId,int pageIndex,int pageSize) {
        return askForLeaveMapper.selectAfls(empId,pageIndex,pageSize);
    }

    //请假申请
    @Override
    public boolean insert(AskForLeave askForLeave) {
        int i = askForLeaveMapper.insertSelective(askForLeave);
        if (i <= 0){
            return false;
        }
        return true;
    }

//    @Override
//    public void addEmpId() {
//        for (int i = 1;i <=92;i++){
//            CheckAtten checkAtten = new CheckAtten();
//            checkAtten.setEmpId(i);
//            checkAttenMapper.insert(checkAtten);
//        }
//    }

//    @Override
//    public void setByEmpId() {
//        for (int i = 1;i <=92;i++){
//            checkAttenMapper.updateCheckAtten0(i);
//        }
//    }

    //打卡
    @Override
    public int upEmpCheckAtten(int i,int empId) {
        return checkAttenMapper.updateCheckAtten(i,empId);
    }

    //检测是否打卡
    @Override
    public CheckAtten queryCheckAttenByEmpId(Integer empId) {
        return checkAttenMapper.selectCheckAttenByEmpId(empId);
    }

    //单挑查询
    @Override
    public AskForLeave queryAflById(int id) {
        return askForLeaveMapper.selectByPrimaryKey(id);
    }

    //修改密码
    @Override
    public boolean upEmpPass(int id, String newPass) {
        int i = empMapper.updateEmpPass(id,newPass);
        if (i == 0){
            return false;
        }
        return true;
    }

    //检测原密码
    @Override
    public boolean queryEmpPassById(Integer empNo, String mPass) {
        Emp emp = empMapper.selectEmpPassById(empNo,mPass);
        if (emp==null){
            return false;
        }
        return true;
    }

    //完善学生信息
    @Override
    public boolean upEmpPwesonal(Emp emp) {
        int i = empMapper.updateEmpPersonal(emp);
        if (i == 0) {
            return false;
        }
        return true;

    }
}
