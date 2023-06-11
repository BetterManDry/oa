package com.lynu.service;

import com.lynu.bean.Dept;
import com.lynu.bean.Emp;

import java.util.List;

public interface DeptService {
    //查询所有部门
    List<Dept> selAllDeptSer();

    Dept selDeptNameSer(int deptNo);

    Dept selDpetNoSer(String deptName);

    boolean addDeptSer(Dept dept);

    Dept selDeptSer(Integer deptNo);

    boolean upDateSer(Dept dept);

    boolean delDeptSer(Integer deptNo);
    //模糊查询
    List<Dept> selDeptNameByIdSer(String deptName);
    //批量删除
    boolean delMoreSer(String ids);
    //查询总条数
    int getCountSer(String likeName);
    //查询所有
    List<Dept> selAllService(int index, int pageSize, String likeName);


}
