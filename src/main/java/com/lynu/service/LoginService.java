package com.lynu.service;

import com.lynu.bean.Admin;
import com.lynu.bean.Emp;

public interface LoginService {
    //管理员登录
    Admin loginAdminService(String adminCode,String adminPwd);

}
