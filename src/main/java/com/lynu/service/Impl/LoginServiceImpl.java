package com.lynu.service.Impl;

import com.lynu.bean.Admin;
import com.lynu.bean.Emp;
import com.lynu.mapper.AdminMapper;
import com.lynu.mapper.EmpMapper;
import com.lynu.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    AdminMapper adminMapper;

    @Autowired
    EmpMapper empMapper;
    //  查询管理员
    @Override
    public Admin loginAdminService(String adminCode, String adminPwd) {
        Admin admin = new Admin();
        admin.setAdminCode(adminCode);
        admin.setAdminPwd(adminPwd);
        return adminMapper.loginAdmin(admin);
    }

}
