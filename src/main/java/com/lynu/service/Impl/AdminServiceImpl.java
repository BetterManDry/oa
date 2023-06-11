package com.lynu.service.Impl;

import com.lynu.bean.Admin;
import com.lynu.mapper.AdminMapper;
import com.lynu.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminMapper adminMapper;
    @Override
    public boolean updateByPrimaryKeySelectiveSer(Admin admin) {
        return adminMapper.updateByPrimaryKeySelective(admin);
    }
}
