package com.lynu.mapper;

import com.lynu.bean.Dept;
import com.lynu.bean.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeptMapper {
    boolean insert(Dept record);

    boolean insertSelective(Dept record);

    boolean updateByPrimaryKey(Dept record);

    boolean updateByPrimaryKeySelective(Dept record);

    List<Dept> selAllDept();

    List<Dept> selDeptNameById(String deptName);

    Dept selDeptName(int deptNo);
    //通过主键查部门
    Dept selDeptNo(String deptName);
    //主键查询当前id所有信息
    Dept selDept(Integer deptNo);
    //主键删除
    boolean deleteByPrimaryKey(Integer deptNo);

    boolean delMore(String ids);
    //逻辑删除
    int logiDel(Integer deptNo);
    //批量逻辑删除
    int logiDelMore(String ids);
    //查询总条数
    int getCount(String likeName);
    //全查询
    List<Dept> selAll(@Param("index") int index, @Param("pageSize") int pageSize, @Param("likeName") String likeName);

}