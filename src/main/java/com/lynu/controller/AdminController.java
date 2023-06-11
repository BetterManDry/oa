package com.lynu.controller;

import com.lynu.bean.Admin;
import com.lynu.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    @RequestMapping("/upAdminPass.a")
    public void upAdminPass(HttpSession session, HttpServletResponse response,String mPass,String newPass,String reNewPass) throws IOException {
        if (newPass.equals(reNewPass)){
            Admin admin = (Admin) session.getAttribute("admin");
            if (mPass.equals(admin.getAdminPwd())){
                admin.setAdminPwd(newPass);
                boolean b = adminService.updateByPrimaryKeySelectiveSer(admin);
                if (b) {
                    response.getWriter().write("密码修改成功");
                }else {
                    response.getWriter().write("密码修改失败");
                }
            }else {
                response.getWriter().write("原密码错误");
            }
        }else {
            response.getWriter().write("新密码不一致");
        }
    }
    @RequestMapping("/upAdminPersonal.a")
    public String upAdminPersonal(MultipartFile upImg, String adminEmail, String adminTel, String adminRemarks, HttpServletRequest request,HttpSession session) throws IOException {
        Admin admin = (Admin) session.getAttribute("admin");
        if (!upImg.isEmpty()){
            String originalFilename = upImg.getOriginalFilename();
            String s = originalFilename.substring(originalFilename.lastIndexOf("."));
            String realPath = request.getServletContext().getRealPath("/fileupload");
            String uuid = UUID.randomUUID().toString().replace("-", "");
            String fileName = uuid+s;
            File file = new File(realPath + "/" + fileName);
            upImg.transferTo(file);
            admin.setAdminPhoto(fileName);
        }
        admin.setAdminEmail(adminEmail);
        admin.setAdminTel(adminTel);
        admin.setAdminRemarks(adminRemarks);
        boolean b = adminService.updateByPrimaryKeySelectiveSer(admin);
        return "redirect:/demo/toPersonal.a";
    }
}
