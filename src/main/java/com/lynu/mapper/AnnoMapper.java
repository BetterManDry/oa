package com.lynu.mapper;

import com.lynu.bean.Anno;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AnnoMapper {

    //查询总条数
    int getCount();

    //单挑查询
    Anno selOne(Integer id);

    //全查询
    List<Anno> selAll(@Param("index") int index, @Param("pageSize") int pageSize);

    //添加公告
    int addAnno(Anno anno);

    //修改
    int updateAnno(Anno anno);

    //主键删除
    int delAnno(Integer annoId);

    //批量删除
    int delMore(String ids);
}
