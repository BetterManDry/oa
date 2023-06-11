package com.lynu.service.Impl;

import com.lynu.bean.Anno;
import com.lynu.mapper.AnnoMapper;
import com.lynu.service.AnnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnoServiceImpl implements AnnoService {
    @Autowired
    AnnoMapper annoMapper;


    @Override
    public int getCountSer() {
        return annoMapper.getCount();
    }

    @Override
    public List<Anno> selAllService(int index, int pageSize) {
        return annoMapper.selAll(index,pageSize);
    }

    @Override
    public boolean addAnnoSer(Anno anno) {
        int i = annoMapper.addAnno(anno);
        if (i > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Anno selOneSer(Integer id) {
        return annoMapper.selOne(id);
    }

    @Override
    public boolean updateAnnoSer(Anno anno) {
        int i = annoMapper.updateAnno(anno);
        if (i > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean delAnnoSer(Integer annoId) {
        int i = annoMapper.delAnno(annoId);
        if (i > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean delMoreSer(String ids) {
        int i = annoMapper.delMore(ids);
        if (i > 0){
            return true;
        }
        return false;
    }

}
