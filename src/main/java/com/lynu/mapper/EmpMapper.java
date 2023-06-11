package com.lynu.mapper;

import com.lynu.bean.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpMapper {
    int insert(Emp record);

    int insertSelective(Emp record);

    boolean updateByPrimaryKeySelective(Emp record);

    Emp updateByPrimaryKey(Emp record);
    //全查询
    List<Emp> selAll(@Param("index") int index,@Param("pageSize") int pageSize,@Param("likeName") String likeName);
    //查询总条数
    int getCount(String likeName);
    //是否添加成功
    int addEmp(Emp emp);
    //主键查询
    Emp selEmpNo(int empNo);
    //更新数据
    boolean updateEmp(Emp emp);

    List<Emp> checkEmpName(String deptName);
    //主键删除
    boolean deleteByPrimaryKey(Integer empNo);
    //逻辑删除
    int logiDel(Integer empNo);
    //批量逻辑删除
    int logiDelMore(String ids);

    //查询员工
    Emp selectEmpByNameAndPass(Emp emp);

    //修改密码
    int updateEmpPass(@Param(value = "id")int id,@Param(value = "newPass")String newPass);

    //检测原密码
    Emp selectEmpPassById(@Param(value = "empNo") Integer empNo,@Param(value = "mPass") String mPass);

    //完善学生信息
    int updateEmpPersonal(Emp emp);

    //查询请假人名字
    String selectEmpNameById(int empId);
}