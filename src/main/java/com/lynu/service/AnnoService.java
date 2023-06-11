package com.lynu.service;

import com.lynu.bean.Anno;
import com.lynu.bean.Dept;

import java.util.List;

public interface AnnoService {

    //查询总条数
    int getCountSer();

    //查询所有
    List<Anno> selAllService(int index, int pageSize);

    //添加
    boolean addAnnoSer(Anno anno);

    //单挑查询
    Anno selOneSer(Integer id);

    //修改
    boolean updateAnnoSer(Anno anno);

    //删除
    boolean delAnnoSer(Integer annoId);

    //批量删除
    boolean delMoreSer(String ids);
}
