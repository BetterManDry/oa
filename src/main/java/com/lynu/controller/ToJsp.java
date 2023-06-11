package com.lynu.controller;

import cn.dsna.util.images.ValidateCode;
import com.lynu.bean.*;
import com.lynu.mapper.AnnoMapper;
import com.lynu.service.AdminService;
import com.lynu.service.AnnoService;
import com.lynu.service.DeptService;
import com.lynu.service.EmpService;
import com.lynu.util.PageUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/demo")
public class ToJsp {

    @Autowired
    EmpService empService;

    @Autowired
    DeptService deptService;

    @Autowired
    AdminService adminService;

    @Autowired
    AnnoService annoService;

    @RequestMapping("/toLogin.a")
    public String toLogin() {
        return "page/login";
    }

    @RequestMapping("/toBackIndex.a")
    public String toBackIndex() {
        return "page/backIndex";
    }


    @RequestMapping("/createCode.a")
    public void createCode(HttpServletResponse response, HttpSession session) throws IOException {
        //设置为图像模式
        response.setContentType("image/jpeg");
        //精致图像缓存
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        ValidateCode validateCode = new ValidateCode(100, 32, 4, 15);
        //把验证码保存在session中
        String code = validateCode.getCode();
        System.out.println("---------------------------------code = " + code);
        session.setAttribute("valiCode", code);
        //把信息传给浏览器
        ServletOutputStream outputStream = response.getOutputStream();
        validateCode.write(outputStream);
    }

//    @RequestMapping("/toEmployee.a")
//    public String toEmployee(HttpServletRequest request, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "5") int pageSize, String likeName) {
//        //数据库查询起始下标起始下标
//        int index = (pageNum - 1) * pageSize;
//        //获得总条数
//        int count = empService.getCountSer(likeName);
//        //总页面
//        int pages = 0;
//        if (count % pageSize == 0) {
//            pages = count / pageSize;
//        } else {
//            pages = (count / pageSize) + 1;
//        }
//        //获取全部数据
//        List<Emp> emps = empService.selAllService(index, pageSize, likeName);
//        request.setAttribute("pageNum", pageNum);
//        request.setAttribute("pages", pages);
//        request.setAttribute("empList", emps);
//        return "empPage/employee";
//    }

    @RequestMapping("/toPass.a")
    public String toPass() {
        return "page/pass";
    }

    @RequestMapping("/toPersonal.a")
    public String toPersonal() {
        return "/page/personal";
    }

    @RequestMapping("/toEmpById.a")
    public String toEmpById(@RequestParam(defaultValue = "1") Integer pageNum,
                            @RequestParam(defaultValue = "5") Integer pageSize,
                            @RequestParam(name = "likeName",required = false) String likeName,
                            HttpServletRequest request) {
        System.out.println("到显示页面的页码"+pageNum);
        System.out.println("likeName = " + likeName);
        int count = empService.getCountSer(likeName);
        PageUtil page = PageUtil.createPage(pageNum,count,pageSize);
        List<Emp> emps = empService.selAllService(page.getPageIndex(),page.getPageSize(),likeName);
        request.setAttribute("pageUtil",page);
        request.setAttribute("empList", emps);
        request.setAttribute("likeName",likeName);
        return "empPage/employee";
    }

    @RequestMapping("/toDeptById.a")
    public String toDeptById(HttpServletRequest request, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "5") Integer pageSize, String likeName) {
        int count = deptService.getCountSer(likeName);
        PageUtil page = PageUtil.createPage(pageNum,count,pageSize);
        List<Dept> deptList = deptService.selAllService(page.getPageIndex(), page.getPageSize(), likeName);
        request.setAttribute("pageUtil",page);
        request.setAttribute("deptList", deptList);
        request.setAttribute("likeName",likeName);
        return "deptPage/dept";
    }

    @RequestMapping("/toAnnoById.a")
    public String toAnnoById(HttpServletRequest request, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "5") Integer pageSize) {
        int count = annoService.getCountSer();
        PageUtil page = PageUtil.createPage(pageNum,count,pageSize);
        List<Anno> annoList = annoService.selAllService(page.getPageIndex(), page.getPageSize());
        System.out.println("annoList = " + annoList);
        request.setAttribute("pageUtil",page);
        request.setAttribute("annoList", annoList);
        return "annoPage/index";
    }

    //查询未审批的请假记录
    @RequestMapping("/toEmpByAfl.a")
    public String toEmpByAfl(HttpServletRequest request,@RequestParam(defaultValue = "1")int pageNum,@RequestParam(defaultValue = "5")int pageSize){
        int count = empService.getCountAfl();
        PageUtil pageUtil = PageUtil.createPage(pageNum,count,pageSize);
        List<AskForLeave> askForLeaveList = empService.queryEmpAfl(pageUtil.getPageIndex(),pageUtil.getPageSize());
        for (AskForLeave askForLeave : askForLeaveList){
            String name = empService.queryEmpNameById(askForLeave.getEmpId());
            askForLeave.setEmpName(name);
        }
        request.setAttribute("askForLeaveList",askForLeaveList);
        return "empSide/empAfl";
    }






}