package com.lynu.service.Impl;

import com.lynu.bean.Dept;
import com.lynu.bean.Emp;
import com.lynu.mapper.DeptMapper;
import com.lynu.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    DeptMapper deptMapper;
    @Override
    public List<Dept> selAllDeptSer() {
        return deptMapper.selAllDept();
    }

    @Override
    public Dept selDeptNameSer(int deptNo) {
        Dept dept = deptMapper.selDeptName(deptNo);
        return dept;
    }

    @Override
    public Dept selDpetNoSer(String deptName) {
        return deptMapper.selDeptNo(deptName);
    }

    @Override
    public boolean addDeptSer(Dept dept) {
        return deptMapper.insertSelective(dept);
    }

    @Override
    public Dept selDeptSer(Integer deptNo) {
        return deptMapper.selDept(deptNo);
    }

    @Override
    public boolean upDateSer(Dept dept) {
        return deptMapper.updateByPrimaryKeySelective(dept);
    }

    @Override
    public boolean delDeptSer(Integer deptNo) {
        int i = deptMapper.logiDel(deptNo);
        if (i > 0){
            return true;
        }
        return false;
    }

    @Override
    public List<Dept> selDeptNameByIdSer(String deptName) {
        return deptMapper.selDeptNameById(deptName);
    }

    @Override
    public boolean delMoreSer(String ids) {
        int i = deptMapper.logiDelMore(ids);
        if (i > 0){
            return true;
        }
        return false;
    }

    @Override
    public int getCountSer(String likeName) {
        return deptMapper.getCount(likeName);
    }

    @Override
    public List<Dept> selAllService(int index, int pageSize, String likeName) {
        return deptMapper.selAll(index,pageSize,likeName);
    }

}
